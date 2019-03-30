package com.bittech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库的事务
 * <p>
 * Author: secondriver
 * Created: 2019/3/24
 */
public class TestJdbc6 {
    
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
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, "root", "root");
            
            //事务控制
            connection.setAutoCommit(false);
            
            
            //3. 创建命令
            statement = connection.createStatement();
            
            //4. 准备SQL语句，执行
            String insertSQL = "insert into memo_group (id ,name,created_time) values (5,'Python组', '2019-03-24 10:15:00')";
            int insertEffect = statement.executeUpdate(insertSQL);
            System.out.println("插入数据：" + insertEffect);
            
            String updateSQL = "update memo_group set name='Python3组'  where id = 5";
            int updateEffect = statement.executeUpdate(updateSQL);
            System.out.println("更新数据：" + updateEffect);
            
            if (insertEffect == 1 && updateEffect == 1) {
                //提交
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                //SQL执行出现异常，回滚
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            //6.关闭资源
            //结果 -> 命令 -> 连接
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
