package com.wschase.jdbc2;

import java.sql.*;

/**
 * Author:WSChase
 * Created:2019/3/25
 */
public class JdbcTemplete1 {
    private Connection connection=null;
    private Statement statement=null;
    private ResultSet resultSet=null;

    //1.加载驱动
    public void load(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.获取连接
    public void connection(){
        String url="jdbc:mysql://127.0.0.1:3306/memo";
        try {
            connection=DriverManager.getConnection(url,"root","1041646364");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //3.建立命令:也应该定义为抽象方法
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


    //5.结果的处理
    public final <T,R> R execute(String sql,Handler<T,R> handler){

        //1.加载驱动
        this.load();

        //2.建立连接
        this.connection();
        //3.创建命令
        this.setStatement();


        //4.准备sql语句并执行，处理结果
            try {
        if(sql.trim().startsWith("select")||sql.trim().startsWith("SELECT")){
                resultSet=this.statement.executeQuery(sql);
                return handler.handler((T) resultSet);
            } else {
            Integer effect = this.statement.executeUpdate(sql);
            return handler.handler((T) effect);
        }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.closeResource();
            }
        return null;
        }
    }


//函数式编程：我们通过接口泛型，输入参数是T型的，返回类型是R型的
//来处理结果。
//使用场景：当我们传入参数的类型和返回值的类型都不相同的时候就会使用函数式编程
interface Handler<T,R>{
    //我们只是定义了这样一个函数，对于它的函数类型以及参数类型我们都不知道，所以用泛型表示

    R handler(T t);
}
