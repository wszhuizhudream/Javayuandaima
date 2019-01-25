package com.wschase.fanxing;

/**
 * Author:WSChase
 * Created:2019/1/23
 */
class Point{
    private Object x;

    private Object y;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }
}
public class TestFan1 {
    public static void main(String[] args) {
        Point p=new Point();
        //设置数据
        p.setX(10);
        p.setY(20);

        //取出数据
        int x= (Integer) p.getX();
        int y=(Integer)  p.getY();
        System.out.println("x="+x+",y="+y);
        //这种方法特别的死板，这样话我们设置数据和取出数据必须是一致的
        //如果不相同那么结果就会出现错误。

    }

}
