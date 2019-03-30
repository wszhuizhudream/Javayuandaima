package com.bittech;

import java.util.List;

/**
 * Author: secondriver
 * Created: 2019/3/24
 */
public class TestJdbc3UseTemplate3 {
    
    public static JdbcTemplate3 jdbcTemplate = new JdbcTemplate3();
    
    public static void queryByName(String name) {
        String sql = "select id ,name,created_time, modify_time  from memo_group  where name in (?)";
        List<MemoGroup> datas = jdbcTemplate.execute(
                sql,
                new String[]
                        {
                                name
                        },
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
        //where name in ('Java新组','PHP组')
        
        /**
         * 预编译命令
         * 1. 赋值参数，下标 1开始，防止SQL注入
         * 2. in 如果？不能传入多个参数
         * 3. 效率比较高
         * 4. 推荐使用预编译命令
         */
        queryByName("'Java新组','PHP组'");
    }
}

