package com.wschase.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**对于JDBC查询功能的实现
 * Author:WSChase
 * Created:2019/3/25
 */
public class JdbcUpdate extends JdbcTemplete {

    @Override
    public ResultSet select() {
        //(1)执行查询功能的时候
            String sql="select id,name,created_time,modify_time from memo_group";
            try {
                resultSet=statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return resultSet;
        }



    public Integer change(){
        return null;
    }


    //这是第五步对于结果的处理
    @Override
    public void selution() {

        //对于查询的结果返回的是表中的数据，需要我们在屏幕中展示
        JdbcTemplete jdbcTemplete=new JdbcUpdate();
        ResultSet result=jdbcTemplete.select();
        try {
            Integer id=result.getInt("id");
            String name=result.getString("name");
            LocalDateTime createdTime=result.getTimestamp("created_time").toLocalDateTime();
            LocalDateTime modifyTime=result.getTimestamp("modify_time").toLocalDateTime();
            System.out.println(String.format("编号：%d    名字：%s    创建时间：%s    修改时间:%s",id,name,createdTime,modifyTime));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
