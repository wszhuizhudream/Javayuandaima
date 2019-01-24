package com.wschase.reflect3.reflect31;

/**这个类的特点是只有一个默认的无参构造
 * 所以当我们想要进行创建对象赋值的时候按照原始方法就必须通过getter、setter方法擦可以达到要求
 * 下面我们就通过反射的方法实现这个功能
 * Author:WSChase
 * Created:2019/1/23
 */
public class Emp {
    private String ename;

    private String job;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
