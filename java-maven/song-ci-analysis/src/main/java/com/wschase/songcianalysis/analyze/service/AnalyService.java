package com.wschase.songcianalysis.analyze.service;

import com.wschase.songcianalysis.analyze.model.AuthorCount;
import com.wschase.songcianalysis.analyze.model.WordCount;
import com.wschase.songcianalysis.analyze.model.WordGroup;

import java.util.List;

/**分析业务——统计作者的诗数量
 * Author:WSChase
 * Created:2019/3/29
 */
public interface AnalyService {
    /**
     * 分析宋词中作者创作的数量
     * @return
     */
    List<AuthorCount> analyzeAuthorCount();

    /**
     * 分析宋词中的词云
     * @return
     */
    List<WordCount> analyzeWordCloud();

    /**
     *分析宋词中的词牌名
     * @return
     */
    List<WordGroup> analyzeWordGroup();
}
