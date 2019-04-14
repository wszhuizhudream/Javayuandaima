package com.wschase.jdbc;

import java.sql.*;

/**
 * Author:WSChase
 * Created:2019/4/14
 */
public class JDBCTemplete {
    private Connection connection=null;
    private Statement statement=null;
    private ResultSet resultSet=null;

    //1.加载驱动
    public void load(){
        try {
            //获取到JDBC这个类
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.获取连接
    public void connection(){
        //指定需要连接的数据库的网址
        String url="jdbc:mysql://127.0.0.1:3306/memo";
        //获取到对应的连接
        try {
            connection=DriverManager.getConnection(url,"root","1041646364");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //3.建立连接命令
    public void setStatement(){
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//6.关闭连接

    public void closeResource(){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //5.结果集的处理
    public final<T,R> R execute(String sql, Handler<T,R> handler){

       //1.加载驱动
       this.load();

       //2.建立连接
        this.connection();

        //3.创建命令
        this.setStatement();

        //4.准备sql语句并执行，处理结果
        if(sql.trim().startsWith("select")){
            try {
                resultSet=this.statement.executeQuery(sql);
                return handler.handler((T) resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                Integer effect=this.statement.executeUpdate(sql);
                return handler.handler((T) effect);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.closeResource();
            }
        }
        return null;
    }

}
    //函数式编程：我们通过接口泛型，输入参数是T型，返回类型是R型的
interface Handler<T,R>{
    R handler(T t);
    }
