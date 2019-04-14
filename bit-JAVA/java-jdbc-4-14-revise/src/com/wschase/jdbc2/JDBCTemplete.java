package com.wschase.jdbc2;

import java.sql.*;

/**JDBC模板
 * Author:WSChase
 * Created:2019/4/14
 */
public class JDBCTemplete {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;

    public void load(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getConnection(){
        String url="jdbc:mysql://127.0.0.1:3306/memo";
        try {
            connection=DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getStatement(){
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeSource(){
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


    //SQL语句的执行以及结果的处理
    //这个是泛型方法
    public final <T,R> R execute(String sql,Handler<T,R> handler){
        this.load();
        this.getConnection();
        this.getStatement();

        //接下来是对结果的处理：但是我们需要实现不同的功能
        if(sql.trim().startsWith("select")||sql.trim().startsWith("SELECT")){
            try {
                resultSet=statement.executeQuery(sql);
                return handler.handler((T) resultSet);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                Integer effect=statement.executeUpdate(sql);
                return handler.handler((T) effect);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }
}

interface Handler<T,R>{
    R handler(T t);
}
