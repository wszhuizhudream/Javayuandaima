package com.bittech;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2019/3/24
 */
public class TestJdbc3UseTemplate2 {
    public static JdbcTemplate2 jdbcTemplate = new JdbcTemplate2();
    
    public static void queryByName(String name) {
        String sql = "select id ,name,created_time, modify_time  from memo_group  where name='"+name+"'";
        List<MemoGroup> datas = jdbcTemplate.execute(
                sql,
                new ResultSetHandler()
        );
        
        if (datas != null) {
            
            for (MemoGroup memoGroup : datas) {
                System.out.println(memoGroup);
            }
        }
    }
    
    public static void main(String[] args) {
        //OK
        //queryByName("Java新组");
        //Java新组' or 1=1 or 1='
        //SQL注入攻击
        //select name,password from user where name= '' and password=''
        queryByName("Java新组' or 1=1 or 1='");
    }
}

class ResultSetHandler implements Handler<ResultSet, List<MemoGroup>> {
    
    
    @Override
    public List<MemoGroup> handler(ResultSet resultSet) {
        //按行取，每一行都有很多列
        List<MemoGroup> memoGroupList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createdTime = resultSet.getTimestamp("created_time")
                        .toLocalDateTime();
                LocalDateTime modifyTime = resultSet.getTimestamp("modify_time").toLocalDateTime();
                
                MemoGroup memoGroup = new MemoGroup();
                memoGroup.setId(id);
                memoGroup.setName(name);
                memoGroup.setCreatedTime(createdTime);
                memoGroup.setModifyTime(modifyTime);
                
                //ORM
                //Java面向对象编程  => Object
                //关系型数据        => Relationship
                //阻抗不匹配
                memoGroupList.add(memoGroup);
                
            }
        } catch (SQLException e) {
        
        }
        return memoGroupList;
    }
}