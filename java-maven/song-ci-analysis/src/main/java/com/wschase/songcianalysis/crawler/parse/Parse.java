package com.wschase.songcianalysis.crawler.parse;

import com.wschase.songcianalysis.crawler.common.Page;

/**
 * Author:WSChase
 * Created:2019/3/28
 */
public interface Parse {
    /*
    解析页面:在参数的地方用final修饰，这样的话我们后面使用就不可以通过重新实例化对象改变这个值
    @param page
     */
    void parse(final Page page);
}
