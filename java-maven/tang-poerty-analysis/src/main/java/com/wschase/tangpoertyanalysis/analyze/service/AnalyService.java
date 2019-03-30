package com.wschase.tangpoertyanalysis.analyze.service;

import com.wschase.tangpoertyanalysis.analyze.model.AuthorCount;

import java.util.List;

/**统计作者的诗数量
 * Author:WSChase
 * Created:2019/3/29
 */
public interface AnalyService {
    /**
     * 分析唐诗中作者创作的数量
     * @return
     */
    List<AuthorCount> analyzeAuthorCount();

    /**
     * 分析唐诗中的词云
     * @return
     */
    List<WordCount> analyzeWordCloud();
}
