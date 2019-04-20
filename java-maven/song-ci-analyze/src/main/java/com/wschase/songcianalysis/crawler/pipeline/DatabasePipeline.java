package com.wschase.songcianalysis.crawler.pipeline;

import com.wschase.songcianalysis.crawler.common.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**数据跟地址清洗
 * Author:WSChase
 * Created:2019/4/20
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
        String title= (String) page.getDataSet().getData("title");
        String dynasty=(String) page.getDataSet().getData("dynasty");
        String author=(String) page.getDataSet().getData("author");
        String content=(String) page.getDataSet().getData("content");

        //将数据存到数据库里面
        String sql="insert into sonci_info2(title,dynasty,quthor,content) values(?,?,?,?)";
        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)) {
            statement.setString(1,title);
            statement.setString(2,dynasty);
            statement.setString(3,author);
            statement.setString(4,content);

            //执行更新
            statement.executeUpdate();
        } catch (SQLException e) {
           logger.error("Database inset occur exception{}");
        }
    }
}
