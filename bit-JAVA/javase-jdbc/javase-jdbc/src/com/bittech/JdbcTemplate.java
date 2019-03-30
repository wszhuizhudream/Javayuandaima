package com.bittech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Author: secondriver
 * Created: 2019/3/24
 */
public abstract class JdbcTemplate {
    
    private Connection connection = null;
    private Statement statement = null;
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
    public void createStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //4.SQL语句
    public abstract String providerSQL();
    
    //5. 处理结果
    public <T> T handler(ResultSet resultSet) {
        return null;
    }
    public <T> T handler(int effect) {
        return null;
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
    
    public final <T> T execute() {
        this.loadDriverClass();
        this.createConnection();
        this.createStatement();
        String sql = this.providerSQL();
        try {
            if (sql.trim().startsWith("select") || sql.trim().startsWith("SELECT")) {
                resultSet = this.statement.executeQuery(sql);
                return this.handler(resultSet);
            } else {
                int effect = this.statement.executeUpdate(sql);
                return this.handler(effect);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        return null;
    }
}
