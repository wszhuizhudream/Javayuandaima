package com.bittech;

/**
 * Author: secondriver
 * Created: 2019/3/24
 */
public class TestJdbc4UseTemplate2 {
    
    //JavaEE Spring Core  Spring-Data-JDBC => JdbcTemplate
    
    public static void main(String[] args) {
        JdbcTemplate2 jdbcTemplate = new JdbcTemplate2();
        String sql = "delete from memo_group where id = 3 ";
        Integer effect = jdbcTemplate.execute(
                sql,
                new Handler<Integer, Integer>() {
                    @Override
                    public Integer handler(Integer effect) {
                        return effect;
                    }
                }
        );
    
        System.out.println("删除结果："+effect);
        
    }
}
