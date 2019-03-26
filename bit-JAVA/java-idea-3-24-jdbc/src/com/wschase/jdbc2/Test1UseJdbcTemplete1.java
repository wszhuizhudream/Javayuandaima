package com.wschase.jdbc2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**实现sql功能
 * Author:WSChase
 * Created:2019/3/25
 */
public class Test1UseJdbcTemplete1 {
    public static JdbcTemplete1 jdbcTemplete1=new JdbcTemplete1();

    public static void queryByName(String name){
        String sql="select id,name,created_time,modify_time from memo_group";
        List<MemoGroup> datas=jdbcTemplete1.execute(
                sql,
                new ResultSetHandler()
        );

        if(datas!=null){
            for(MemoGroup memoGroup:datas){
                System.out.println(memoGroup);
            }
        }
    }

    public static void main(String[] args) {
        queryByName("java新租' or 1=1 or 1=");

    }

}

class ResultSetHandler implements Handler<ResultSet,List<MemoGroup>>{

    @Override
    public List<MemoGroup> handler(ResultSet resultSet) {
           List<MemoGroup> memoGroupList=new ArrayList<>();
           try {
               while (resultSet.next()) {
                   int id = 0;
                   id = resultSet.getInt("id");
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
                   //java面向对象编程=>Object
                   //关系型数据      =>Relationship
                   //阻抗不匹配

                   memoGroupList.add(memoGroup);
               }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return memoGroupList;
    }
}

