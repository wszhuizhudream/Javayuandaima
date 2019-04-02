package com.wschase.tangpoertyanalysis.analyze.model;

import lombok.Data;

/**AuthorSampleReels :作者的作品数量
 * Author:WSChase
 * Created:2019/3/29
 */
@Data
public class AuthorCount {
    //作者的名字
    private String author;

    //作者作品的数量
    private Integer count;
}
