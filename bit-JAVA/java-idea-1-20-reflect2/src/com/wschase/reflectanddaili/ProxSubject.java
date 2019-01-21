package com.wschase.reflectanddaili;

/**
 * Author:WSChase
 * Created:2019/1/20
 */
public class ProxSubject implements ISubject{

    public ProxSubject(ISubject target) {
        this.target = target;
    }

    private ISubject target;

    private void prepare(){
        System.out.println("准备吃饭");
    }
    @Override
    public void eate() {
        this.prepare();
        this.target.eate();
        this.clean();
    }

    private void clean(){
        System.out.println("清理");
    }
}
