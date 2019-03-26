package com.wschase.jdbc;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Author:WSChase
 * Created:2019/3/24
 */
public class Testjdbc1 {
    public static void main(String[] args) {
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //2.获取连接
        String url="jdbc:mysql://127.0.0.1:3306/memo";
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection=DriverManager.getConnection(url,"root","1041646364");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3.创建命令
        try {
            statement=connection.createStatement();
        //4.准备SQL语句，执行
            String sql="select id,name,created_time,modify_time from memo_group";
            resultSet=statement.executeQuery(sql);

        //5.返回结果，处理结果
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                LocalDateTime createdTime=resultSet.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modifyTime=resultSet.getTimestamp("modify_time").toLocalDateTime();
                System.out.println(String.format(
                        "编号：%d    名称：%s    创建时间：%s    修改时间：%s",id,name,createdTime,modifyTime));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        //6.关闭资源
        //结果->命令->连接
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
}
