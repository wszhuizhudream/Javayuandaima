package com.bittech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

/**
 * Author: secondriver
 * Created: 2019/3/24
 */
public class TestJdbc5 {
    
    public static void main(String[] args) {
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        //2.获取连接
        //JDBC API
        //第一种：DriverManager
        //第二种：DataSource
        //url :   JDBC url schema :
        //       jdbc:<数据库产品名称>://host:port/<databaseName>?param1=value1&param2=value2
        //user : root
        //password : root
        String url = "jdbc:mysql://127.0.0.1:3306/memo";
        String sql = "select id ,name,created_time, modify_time  from memo_group";
        //自动关闭资源
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
        ) {
            //5.返回结果，处理结果
            while (resultSet.next()) {
                //按行取，每一行都有很多列
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createdTime = resultSet.getTimestamp("created_time")
                        .toLocalDateTime();
                LocalDateTime modifyTime = resultSet.getTimestamp("modify_time").toLocalDateTime();
                System.out.println(String.format(
                        "编号：%d   名称：%s   创建时间：%s  修改时间：%s"
                        , id, name, createdTime, modifyTime));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
