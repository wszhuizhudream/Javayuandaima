package com.wschase.jdbc;

import java.sql.*;

/**
 * Author:WSChase
 * Created:2019/3/25
 */
public class JdbcTemplete {
    private Connection connection=null;
    private Statement statement=null;
    private ResultSet resultSet=null;

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

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
            connection=DriverManager.getConnection(url,"root","1041646364");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getStatment1(){
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
    public final  <T,R> R execute(String sql,Hanlder<T,R> hanlder){

        this.load();
        this.getConnection();
        this.getStatment1();

        //接下来是对结果的处理：但是我们还是需要通过分类讨论才能实现不同的功能
        if(sql.trim().startsWith("select")||sql.trim().startsWith("SELECT")){
            try {
                resultSet=statement.executeQuery(sql);

                //得到结果以后就直接返回结果:通过传进来的参数调用处理结果的方法
                return hanlder.hanlder((T) resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                Integer effect=statement.executeUpdate(sql);
                return hanlder.hanlder((T) effect);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //如果都不满足说明这个语句有问题直接返回null
        return null;

    }



}

interface Hanlder<T,R>{
    R hanlder(T t);
        }
