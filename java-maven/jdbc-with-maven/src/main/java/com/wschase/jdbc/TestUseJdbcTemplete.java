package com.wschase.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**实现JDBC：通过java语言操作数据库中的查询语言
 * Author:WSChase
 * Created:2019/3/25
 */
public class TestUseJdbcTemplete {

    //定义这个对象是为了访问它里面的方法
    public static JdbcTemplete jdbcTemplete =new JdbcTemplete();

    public static Scanner scanner=new Scanner(System.in);

        static String sql=scanner.nextLine();

    /*
    查询功能
     */

    //通过名字进行查找数据
    public static void queryByName(String name){

        //datas就是经过处理以后的结果
        List<Member> datas= jdbcTemplete.execute(sql,new ResultHandler());
        if(datas!=null){
            for(Member member:datas){
                //member其实是一个对象，里面放的元素就是我们需要展示的表格中的数据
                System.out.println(member);
            }
        }
    }




    /*
    删除功能
     */
    public static void delete(){
        JdbcTemplete jdbcTemplete=new JdbcTemplete();
        Integer effect=jdbcTemplete.execute(sql, new Hanlder<Integer, Integer>() {
            @Override
            public Integer hanlder(Integer effect) {
                return effect;
            }
        });

        System.out.println("删除的结果是："+effect);
    }



    public static void test(){
        if(sql.trim().startsWith("select")||sql.trim().startsWith("SELECT")){
            System.out.println("请输入你想要查询列的列名：");
            String name=scanner.nextLine();
            TestUseJdbcTemplete.queryByName(name);
        }else if(sql.trim().startsWith("delete")||sql.trim().startsWith("DELETE")){

            TestUseJdbcTemplete.delete();
        }
    }
}


/*
结果处理
 */
class ResultHandler implements Hanlder<ResultSet,List<Member>>{

    //这个集合就是用来装这个Member对象的
    private final List<Member> list=new ArrayList<>();

    @Override
    public List<Member> hanlder(ResultSet resultSet) {

            try {
        while (resultSet.next()){
            int id=0;
                id=resultSet.getInt("id");
                String name=resultSet.getString("name");
            LocalDateTime createdTime=resultSet.getTimestamp("created_time").toLocalDateTime();
            LocalDateTime modifyTime=resultSet.getTimestamp("modify_time").toLocalDateTime();

            Member member=new Member();
            member.setId(id);
            member.setName(name);
            member.setCreatedTime(createdTime);
            member.setModifyTime(modifyTime);

            //将经过修改以后的这个值放进集合里面
            list.add(member);
            }
        } catch (SQLException e) {
                e.printStackTrace();
            }

        return list;
    }
}
