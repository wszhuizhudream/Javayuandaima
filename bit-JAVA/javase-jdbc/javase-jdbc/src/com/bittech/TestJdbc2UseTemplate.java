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
public class TestJdbc2UseTemplate extends JdbcTemplate {
    
    
    @Override
    public String providerSQL() {
        return "select id ,name,created_time, modify_time  from memo_group where id < 3 ";
    }
    
    @Override
    public <T> T handler(ResultSet resultSet) {
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
        return (T) memoGroupList;
    }
    
    public static void main(String[] args) {
        
        JdbcTemplate jdbcTemplate = new TestJdbc2UseTemplate();
        List<MemoGroup> datas = jdbcTemplate.execute();
        if (datas != null) {
            
            for (MemoGroup memoGroup : datas) {
                System.out.println(memoGroup);
            }
        }
        
    }
}
