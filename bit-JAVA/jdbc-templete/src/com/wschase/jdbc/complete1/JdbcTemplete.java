package com.wschase.jdbc.complete1;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**对JDBC的实现:总共几个方法
 * Author:WSChase
 * Created:2019/3/25
 */
public class JdbcTemplete {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;


    //1.加载驱动
    public void loadDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.建立连接
    public void getConnction(){
        String url="jdbc:mysql://127.0.0.1:3306/memo";
        connection=DriverManager.getConnection()
    }



}
