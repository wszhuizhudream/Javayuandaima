package com.wschase.tangpoertyanalysis.analyze.dao.impl;

import com.wschase.tangpoertyanalysis.analyze.dao.AnalyzeDao;
import com.wschase.tangpoertyanalysis.analyze.entity.PoertyInfo;
import com.wschase.tangpoertyanalysis.analyze.model.AuthorCount;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:WSChase
 * Created:2019/3/29
 */
public class AnalyzeDaoImpl implements AnalyzeDao {

    //JDBC变成就需要先把数据源准备好
    private final DataSource dataSource;

    public AnalyzeDaoImpl(DataSource dataSource){
        this.dataSource=dataSource;
    }


    @Override
    public List<AuthorCount> analyzeAuthorCount() {
        List<AuthorCount> datas=new ArrayList<>();
        //因为sql语句短，所以我们可以直接将sql语句定义在外面
        String sql="select count(*) as count ,author from poetry_info group by author;";

        //try自动关闭
        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery()
        ){
           while(resultSet.next()){
               //首先实例化一个作者作品集的对象，然后通过这个对象在数据库中获取两个属性：作者名字、作品数量
               AuthorCount authorCount=new AuthorCount();
               //从数据库中获取作何名字
               authorCount.setName(resultSet.getString("author"));
               //从数据库中获取作者作品数量
               authorCount.setCount(resultSet.getInt("count"));
               //将取出来的作者作品数量放进集合里面
               datas.add(authorCount);
           }

        }catch (SQLException e){

        }
        return datas;
    }

    @Override
    public List<PoertyInfo> queryAllPoetryInfo() {
        List<PoertyInfo> datas=new ArrayList<>();
        //因为sql语句短，所以我们可以直接将sql语句定义在外面
        String sql=" select title,dynasty,author,content from poetry_info;";

        /**
         * 下面是JDBC编程
         */
        //try自动关闭
        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery()
        ){
            while(resultSet.next()){
                PoertyInfo poerty=new PoertyInfo();
                //数据库跟我们的java对象是不匹配的，我们需要先从数据库中取出来再将数据的值赋给对象
                poerty.setTitle(resultSet.getString("title"));
               poerty.setDynasty(resultSet.getString("dynasty"));
               poerty.setAuthor(resultSet.getString("author"));
               poerty.setContent(resultSet.getString("content"));
               //ORM框架：可以改变JDBC编程——如Mybatis（通过它可以将JDBC简化）

                datas.add(poerty);

            }

        }catch (SQLException e){

        }

        return null;
    }
}
