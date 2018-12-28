/**
 * Author: secondriver
 * Created: 2018/12/11
 */
package com.bittech.generic;
/*

1. 泛型类
   1.1 className<T,S>  使用时指定具体的类型
   1.2 ? extends classType  指定类型参数的上限

2. 泛型方法
   2.1 <T> returnValue method(T args)
   2.2 泛型方法和泛型类是相互独立
   2.3 ? , ? extends classType(不能改内容) , ? super classType(可以改内容)

3. 泛型接口
   3.1 interfaceName<T>
   3.2 className<T> implements interfaceName<T>
   3.2 className    implements interfaceName<String>
   3.3 结合匿名内部类使用

4. 泛型擦除
   4.1 泛型信息存在于编译阶段，运行时类型擦除
   4.2 未指定类型参数上限时，类型统一设置Object
   4.3 指定类型参数上限时，类型统一设置为上限类型

 */