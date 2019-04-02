package com.wschase.songcianalysis.crawler.pipeline;

import com.wschase.songcianalysis.crawler.common.Page;

/**
 * Author:WSChase
 * Created:2019/3/28
 */
public interface Pipeline {
    /**
     * 管道处理Page中的数据
     * @param page
     */
    void pipeline(final Page page);
}
