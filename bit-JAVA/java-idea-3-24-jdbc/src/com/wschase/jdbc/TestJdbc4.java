package com.wschase.jdbc;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Author:WSChase
 * Created:2019/3/25
 */
public class TestJdbc4 {
    public static void main(String[] args) {
        String url="jdbc:mysql://127.0.0.1:3306/memo";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载JDBC驱动程序
            Class.forName("com.mysql.jdbc.Driver");

            //2.创建数据库连接
            connection = DriverManager.getConnection(url,"root","1041646364");
            // connection = DriverManager.getConnection(url, "root", "123456");

            //3.创建操作命令
            statement = connection.createStatement();
            //4.执行sql语句
            String sql = "select id,name,created_time, modify_time from memo_group";
            resultSet = statement.executeQuery(sql);
            //5.处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime creat_time = resultSet.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modify_time = resultSet.getTimestamp("modify_time").toLocalDateTime();
                System.out.println(String.format("编号：%d 名称：%s 创建时间：%s 修改时间：%s", id, name, creat_time, modify_time));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();

                }
                if (connection != null) {
                    connection.close();

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}
