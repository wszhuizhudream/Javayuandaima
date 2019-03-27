package com.wschase.replace1;

/**动态代理
 * Author:WSChase
 * Created:2019/3/26
 */
public class TestReplace {
    public static void main(String[] args) {
        ISubject iSubject=(ISubject) new ProxySubject().bind(new RealSubject());
        iSubject.eat("面条",10);
    }
}
