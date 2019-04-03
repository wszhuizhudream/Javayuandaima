package com.wschase.songcianalysis.analyze.model;

import lombok.Data;

/**词牌名数量统计
 * Author:WSChase
 * Created:2019/4/2
 */
@Data
public class WordGroup {
    //词牌名的名字
    private String wordGroup;

    //词牌名出现的次数
    private Integer count;
}
