package com.bittech.reflect.proxy;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class ProxySubject implements ISubject {
    
    private final ISubject target;
    
    public ProxySubject(ISubject target) {
        this.target = target;
    }
    
    private void prepare() {
        System.out.println("准备");
    }
    
    @Override
    public void eat() {
        this.prepare();
        this.target.eat();
        this.clear();
    }
    
    private void clear() {
        System.out.println("清理");
    }
    
}
