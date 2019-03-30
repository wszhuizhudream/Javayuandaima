package com.bittech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 预编译命令
 * 1. 赋值参数，下标 1开始，防止SQL注入
 * 2. in 如果？不能传入多个参数
 * 3. 效率比较高
 * 4. 推荐使用预编译命令
 */

/**
 * Author: secondriver
 * Created: 2019/3/24
 */
public class JdbcTemplate3 {
    
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    
    //1.加载驱动程序
    public void loadDriverClass() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    //2.连接
    public void createConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/memo";
        try {
            connection = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    //3.创建命令
    public void createStatement(String sql) {
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //6.关闭资源
    public void closeResource() {
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
    
    public final <T, R> R execute(String sql, String[] args, Handler<T, R> handler) {
        this.loadDriverClass();
        this.createConnection();
        //select id ,name,created_time, modify_time  from memo_group  where name=?
        //1 ... n  ? 表示占位符
        this.createStatement(sql);
        //参数赋值
        //通过反射的方式让参数赋值更加灵活
        for (int i = 0; i < args.length; i++) {
            try {
                //所有参数类型都是String
                this.statement.setString(i + 1, args[i]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        try {
            if (sql.trim().startsWith("select") || sql.trim().startsWith("SELECT")) {
                //预编译命令此处执行时，SQL语句不需要传入
                resultSet = this.statement.executeQuery();
                return handler.handler((T) resultSet);
            } else {
                Integer effect = this.statement.executeUpdate();
                return handler.handler((T) effect);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        return null;
    }
}
