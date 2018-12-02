//1.类名
//2.静态属性
//3.静态块
//4.非静态块
//5.构造块
//6.普通块  





//内部类可以轻易的操作外部的属性，但是外部的类不可以轻易的操作内部类的属性

   public class Outer { 
    
    private String msg = "this is a atrribute";
    
    //Inner属于内部类 外部类 Outer（内部类相当于实现一个局部封装）
    class Inner {
        
        private String msg  = "this is a inner attribute";
        
        public void print(){
            System.out.println("这是个从Inner的方法中输出的："+ 
            Outer.this.msg); //内部类访问外部类的属性：外部类的类名.this.属性名
                              //内部类访问自己内部类的属性：this.属性名
        }

    }
    
    public void fun(){
        System.out.println(this.msg);
        //System.out.println(Inner.this.msg);//error
        //this.print(); //error
        Inner inner = new Inner();
        inner.print();
    }

    
    public static void main(String[] args){
        Outer outer = new Outer();
        outer.fun();
               
    }
}
    
