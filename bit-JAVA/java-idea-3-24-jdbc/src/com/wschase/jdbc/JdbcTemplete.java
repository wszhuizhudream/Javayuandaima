package com.wschase.jdbc;

import java.sql.*;

/**JDBC抽象为一个抽象类
 * Author:WSChase
 * Created:2019/3/24
 */
abstract class JdbcTemplete {
   Connection connection=null;
     Statement statement=null;
     ResultSet resultSet=null;


    Integer effect=0;
    public void complete(){
        this.load();
        this.connection();
        this.setStatement1();
        this.select();
        this.selution();
        this.closeAll();
    }

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
    public void setStatement1(){
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //4.准备SQL语句，执行SQL语句——并且返回结果：但是我们发现一个问题，我们在执行不同的SQL语句的时候
                                            //返回的类型是不同的。所以我们需要将这个方法重载一下

    //(1)执行查询功能的时候
    public abstract ResultSet select();
    //(2)执行更新、删除、修改功能的时候
    public abstract Integer change();


    //5.处理返回结果：抽象方法
    public abstract void selution();

    //6.关闭连接
    public void closeAll(){
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
}
