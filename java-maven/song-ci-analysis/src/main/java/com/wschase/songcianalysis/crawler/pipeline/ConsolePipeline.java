package com.wschase.songcianalysis.crawler.pipeline;

import com.wschase.songcianalysis.crawler.common.Page;


import java.util.Map;


/**控制台
 * Author:WSChase
 * Created:2019/3/28
 */
public class ConsolePipeline implements Pipeline{

    @Override
    public void pipeline(Page page) {
        Map<String,Object> data = page.getDataSet().getData();
        //存储
        System.out.println(data);
    }
}
