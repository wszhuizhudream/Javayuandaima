package com.wschase.kebiancanshu;

/**可变参数：有了可变参数以后我们可以在任何时候传入任何个参数，不会因为不知道有多少个参数而受限制
 * Author:WSChase
 * Created:2019/1/23
 */
public class Test1 {
    public static int add(int...data){
        int result=0;
        for(int i=0;i<data.length;i++){
            result+=i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(add(1,2,3));
        System.out.println(add(new int[]{1,3,4}));
    }

}
