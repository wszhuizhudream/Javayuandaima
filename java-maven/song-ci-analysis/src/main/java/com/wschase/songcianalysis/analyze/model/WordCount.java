package com.wschase.songcianalysis.analyze.model;

import lombok.Data;

/**词云
 * Author:WSChase
 * Created:2019/3/29
 */
@Data
public class WordCount {
    //每个词
    private String word;

    //每个词出现的数量
    private Integer count;

}
