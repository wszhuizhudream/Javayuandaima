package com.wschase.jdbc;

import java.sql.*;
import java.time.LocalDateTime;

/**JDBC编程
 * Author:WSChase
 * Created:2019/3/24
 */
public class Testjdbc2 {
    public static void main(String[] args) {
        //1.加载驱动程序:获取到java下加载驱动的这个类
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
            connection= DriverManager.getConnection(url,"root","1041646364");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3.创建命令
        try {
            statement=connection.createStatement();

        //4.准备SQL语句,并执行(因为执行的时候需要用到我们的statement命令来执行，所以将SQL执行放到异常里面)
        String sql="select id ,name,created_time,modify_time from memo_group";
        resultSet=statement.executeQuery(sql);
        //5.返回结果，处理结果
            while (resultSet.next()){//当它为true的时候说明这个执行的结构是符合我们预期的，所以将它进行返回
                Integer id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                LocalDateTime localDateTime=resultSet.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modifyTime=resultSet.getTimestamp("modify_time").toLocalDateTime();

                //处理结果：下面将查询的结果打印出来
                System.out.println(String.format("编号：%d   名称：%s   创建时间：%s   修改时间：%s",id,name,localDateTime,modifyTime));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        //6.关闭资源
        //结果->命令->连接
            if(resultSet!=null){

                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                try {

                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
