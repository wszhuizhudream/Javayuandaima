package com.wschase.songcianalysis.analyze.dao;

import com.wschase.songcianalysis.analyze.entity.SongCiInfo;
import com.wschase.songcianalysis.analyze.model.AuthorCount;

import java.util.List;

/**统计作者作品的数量
 * Author:WSChase
 * Created:2019/3/29
 */
public interface AnalyzeDao {
    /**
     * 功能1：分析宋词中作者的创作数量
     * @return
     */
    List<AuthorCount> analyzeAuthorCount();


    /**
     * 功能2：查询所有的业务，提供给业务层进行分析
     */
    List<SongCiInfo> queryAllPoetryInfo();

}
