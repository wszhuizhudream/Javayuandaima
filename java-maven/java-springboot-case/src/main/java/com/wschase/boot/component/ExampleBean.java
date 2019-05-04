package com.wschase.boot.component;

/**
 * Author:WSChase
 * Created:2019/4/29
 */
//假设这个类是第三方的类，我们想要将它变为Bean，由于我们无法操作它的源码所以我们需要通过注解的方式
public class ExampleBean {

    private String name;

    public void init(){

    }

    public void destroy(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
