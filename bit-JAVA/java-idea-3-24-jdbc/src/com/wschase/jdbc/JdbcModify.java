package com.wschase.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author:WSChase
 * Created:2019/3/25
 */
public class JdbcModify extends JdbcTemplete {
    @Override
    public ResultSet select() {
        return null;
    }



    //对于删除的SQL语句
    @Override
    public Integer change(){
        String sql="delete from memo_group where id = 2 ";
        try {
            effect=statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return effect;

    }


    //对于结果的处理
    @Override
    public void selution() {
        JdbcTemplete jdbcTemplete=new JdbcModify();
        Integer result=jdbcTemplete.change();
        System.out.println("删除的语句为：%d"+result);

    }
}
