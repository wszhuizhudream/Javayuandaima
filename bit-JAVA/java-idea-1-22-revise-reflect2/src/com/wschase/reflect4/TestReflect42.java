package com.wschase.reflect4;

/**4.2双亲委派模型
 * 工作流程：
 * 如果一个类加载器收到了类加载请求，它首先不会自己去尝试加载这个类
 * 而是把这个请求委托给父类去完成，每一个层次的类加载器都是如此。因此，所有
 * 的加载请求都应当传送到顶层的BootStrap加载器中，只有当父加载器反馈无法完
 * 成这个加载请求时（在自己搜索范围中没有找到此类），子加载器才会尝试自己去加载。
 * Author:WSChase
 * Created:2019/1/23
 */

//例子：观察ClassLoader.loadClass()方法
public class TestReflect42 {
    public static void main(String[] args) {
       // Class<?> c=findLoadedClass(name);
    }
}
