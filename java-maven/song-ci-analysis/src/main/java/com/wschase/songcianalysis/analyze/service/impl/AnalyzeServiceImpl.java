package com.wschase.songcianalysis.analyze.service.impl;
import com.wschase.songcianalysis.analyze.dao.AnalyzeDao;
import com.wschase.songcianalysis.analyze.entity.SongCiInfo;
import com.wschase.songcianalysis.analyze.model.AuthorCount;
import com.wschase.songcianalysis.analyze.service.AnalyService;
import com.wschase.songcianalysis.analyze.service.WordCount;
import lombok.Data;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;

import java.util.*;
@Data

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
//                return *o1.getCount().compareTo(o2.getCount());

                //降序
                return -1*o1.getCount().compareTo(o2.getCount());
            }
        });
        return authorCounts;
    }


    @Override
    public List<WordCount> analyzeWordCloud() {
        //1.查询所有的数据
        //2.取出title content
        //3.分词：key=词语：value=词语出现的次数（过滤 /w,length<2,null这些都不要）
        //4.统计k-v
        //首先从数据库中取出来所有的词
        //Map集合里面存放的key是真正的词语，value是这个词出现的次数
        Map<String, Integer> map = new HashMap<>();
        List<SongCiInfo> poetryInfos = analyzeDao.queryAllPoetryInfo();//此时获取的是古诗中的四个信息

        for (SongCiInfo songCiInfo :poetryInfos) {

            //定义一个集合，这个集合里面存储的类型是词性
            List<Term> terms = new ArrayList<>();
            //将取出来的内容分解出标题和内容
            String title = songCiInfo.getTitle();
            String content = songCiInfo.getContent();

            //将从数据库里面取出来并分解以后的标题和内容放进词性这个集合里面，我们对他们进行词性的分析
            terms.addAll(NlpAnalysis.parse(title).getTerms());
            terms.addAll(NlpAnalysis.parse(content).getTerms());

            //过滤一个集合
            //注意：ArrayList是一个并发修改的，不能用for循环来进行修改，所以我们使用迭代器
            Iterator<Term> iterator = terms.iterator();
            while (iterator.hasNext()) {
                Term term = iterator.next();
                //（1）关于词性的过滤
                if (term.getNatureStr() == null || term.getNatureStr().equals("w")) {
                    //这个地方表示如果是在诗里面是空格的或者是标点都直接将它去除
                    iterator.remove();
                    continue;
                }
                //（2）关于词长度的过滤
                if (term.getRealName().length() < 2) {
                    iterator.remove();
                    continue;
                }

                //经过过滤以后我们的集合里面放的就是词语，但是这些词语可能会有重复的，所以我们接下来对这些词语进行统计
                String realName = term.getRealName();//获得一个词
                int count ;
                if (map.containsKey(realName)) {
                    //如果有那么就是在原来的基础上加1
                    count = map.get(realName) + 1;
                } else {
                    //如果没有这个词语，那么它就是第一次出现
                    count = 1;
                }
                map.put(realName, count);

            }
        }
        //但是需要注意的是我们这个方法的返回值是List<WordCount>，所以我们需要将Map集合转化为List集合
        List<WordCount> wordCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            WordCount wordCount = new WordCount();
            wordCount.setCount(entry.getValue());
            wordCount.setWord(entry.getKey());
            //我们解析出来了以后需要将这些信息加入集合里面
            wordCounts.add(wordCount);
        }
        return wordCounts;
    }


}
