package com.wschase.neijian;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
/**内建函数式接口
 * Author:WSChase
 * Created:2018/12/3
 */
////1.功能型接口（有进有出）
//public class Neijian {
//    public static void main(String[] args) {
//        Function<Integer,String>fun=String::valueOf;
//        System.out.println(fun.apply(1000));
//    }
//}
////2.供给型（无进有出）
//public class Neijian{
//    public static void main(String[] args) {
//        Supplier<String> sup="hello"::toUpperCase;
//        System.out.println(sup.get());
//    }
//}
////3.消费型（有进无出）
//public class Neijian{
//    public static void main(String[] args) {
//        Consumer<String> cons=System.out::println;
//        cons.accept("哈喽");
//
//    }
//}
////4.断言型（预测以什么开始，以什么结束）
//public class Neijian{
//    public static void main(String[] args) {
//        Predicate<String> pre="##jsshhd112"::startsWith;
//        System.out.println(pre.test("##"));
//    }
//}