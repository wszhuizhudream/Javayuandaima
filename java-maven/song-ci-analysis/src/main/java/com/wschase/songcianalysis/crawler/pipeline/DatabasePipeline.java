package com.wschase.songcianalysis.crawler.pipeline;

import com.wschase.songcianalysis.crawler.common.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Author:WSChase
 * Created:2019/3/28
 */
public class DatabasePipeline implements Pipeline {
    //添加一个日志
    private final Logger logger=LoggerFactory.getLogger(DatabasePipeline.class);


    //数据源
    private final DataSource dataSource;

    public DatabasePipeline(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void pipeline(Page page) {
        String title=(String) page.getDataSet().getData("title");
        String dynasty=(String) page.getDataSet().getData("dynasty");
        String author=(String) page.getDataSet().getData("author");
        String content=(String) page.getDataSet().getData("content");
    //将数据源存到数据库里面
            String sql="insert into songci_info(title, dynasty, author, content) values (?,?,?,?)";
        try(Connection connection=dataSource.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql)) {
            statement.setString(1,title);
            statement.setString(2,dynasty);
            statement.setString(3,author);
            statement.setString(4,content);

            //执行更新，将数据放入到数据库
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Database insert occur exception {}.",e.getMessage());
        }
    }



}
