package com.wschase.tangpoertyanalysis.analyze.service.impl;

import com.wschase.tangpoertyanalysis.analyze.dao.AnalyzeDao;
import com.wschase.tangpoertyanalysis.analyze.entity.PoertyInfo;
import com.wschase.tangpoertyanalysis.analyze.model.AuthorCount;
import com.wschase.tangpoertyanalysis.analyze.service.AnalyService;
import com.wschase.tangpoertyanalysis.analyze.service.WordCount;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author:WSChase
 * Created:2019/3/29
 */
public class AnalyzeServiceImpl implements AnalyService {

    //面向接口编程
    private final AnalyzeDao analyzeDao;

    public AnalyzeServiceImpl(AnalyzeDao analyzeDao) {
        this.analyzeDao = analyzeDao;
    }

    @Override
    public List<AuthorCount> analyzeAuthorCount() {
        //此处结果并未排序
        //如果要排序，则有两种方式：
            //（1）DAO层SQL排序
            //（2）service层进行数据排序
        List<AuthorCount> authorCounts = analyzeDao.analyzeAuthorCount();
        Collections.sort(authorCounts, new Comparator<AuthorCount>() {
            @Override
            public int compare(AuthorCount o1, AuthorCount o2) {
//                //升序方法1：
//                return o1.getCount()-o2.getCount();

                //升序方法2；
                return o1.getCount().compareTo(o2.getCount());

//                //降序
//                return -1*o1.getCount().compareTo(o2.getCount());
            }
        });
        return authorCounts;
    }



    @Override
    public List<WordCount> analyzeWordCloud() {
        //1.查询所有的数据
        //2.取出title content
        //3.分词：key=词语：value=词语出现的次数
        //4.统计k-v
        //首先取出来所有的词
        List<PoertyInfo> poerties=analyzeDao.queryAllPoetryInfo();
        return null;
    }


}
