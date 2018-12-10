package com.wschase.io;

/**File文件操作类
 * Author:WSChase
 * Created:2018/12/4
 */

import java.io.*;
import java.util.Date;

/**
 * File类是一个普通类，可以直接产生实例化对象。对于File实例化对象有两个方法：
 * public File(String pathname);
 * public File(String parent,String child);->设置父路径和子路径
 *
 *
 */

//public class Practice {
//    public static void main(String[] args) throws IOException {
//         //1.创建新文件
//        //File只能创建文件本身，对其内容并不会改变
//        File file = new File("....");
//        try{
//            file.createNewFile();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        //判断文件是否存在
//        //public boolean exits();
//        //删除文件
//        //public boolean delete();


//      //2.编写文件的基本操作（如果文件不存在则进行创建；存在则删除）
//       File file =new File();//这只是实例化一个对象
//       if(file.exists()){
//           file.delete();
//       }else{
//           file.createNewFile();
//       }
//    }
//}

////        3.文件目录的操作
//        //separator由不同操作系统下的JVM决定到底使用哪种分隔符
//        File file=new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"j1"+File.separator+"a2");
//       //上面写的这个父路径在我的电脑里面是存在的所以，对于下面的这个条件的判断结果是false
//       //路径的最后一个就是文件的名字
//        if(!file.getParentFile().exists()){//判断父File对象是否存在
//            file.getParentFile().mkdirs();//-》对象（父File的对象）调用它的方法不管由多少级父目录都创建父目录
//        }
//        if(file.exists()){
//            //当前文件是否存在的判断->我们是定的这个文件a1在这个路径下面是不存的，所以经过下面代码的执行会创建这个文件
//            file.delete();
//        }else{
//            file.createNewFile();
//        }

//        4.文件信息
//// （1）取得文件信息操作
//        //这是我们需要进行操作的文件
//        File file = new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"a1");
//        //首先对于以上的路径我们并不知道是否为文件，所以需要我们判断这个枯井是否为文件
//        if(file.exists()&&file.isFile()){
//            System.out.println("文件大小"+file.length());
//            System.out.println("最后一次修改日期："+new Date(file.lastModified()));
//        }

//// （2）列出目录中的全部组成
//        //下面是需要操作的文件
//    File file=new File("E:"+File.separator+"learn"+File.separator+"javaio");
//    //保证这个目录是存在的
//        if(file.exists()&&file.isDirectory()){
//            //列出目录中的所有内容
//            //listFile()这个方法：file是普通文件返回null；file是目录返回目录下的所有内容（文件以及文件夹）
//            File[] result=file.listFiles();
//            for(int i=0;i<result.length;i++){
//                System.out.println(result[i]);
//            }
//        }

////递归打印当前目录下的所有层次的文件信息
//File file = new File("E:"+File.separator+"learn"+File.separator+"javaio");
//    listAllFiles(file);//从此处开始递归
//    }
//    public static void listAllFiles(File file){
//        //将给定目录的文件列出其一级信息，然后再对这些一级信息进行判断，将不是普通文件的再次进行listFile()，直到这个文件为普通文件
//        if(file.isDirectory()){
//            File[] result=file.listFiles();//继续列出子目录内容
//            if(result!=null){
//                for(File file2:result){
//                    listAllFiles(file2);
//                }
//            }
//        }else{
//            //给的这个file就是文件，直接打印
//            System.out.println(file);
//        }


//二、字节流与字符流
////1.字节输出流（文件内容追加）
//File file =new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"a1");
//if(!file.getParentFile().exists()){
//    file.getParentFile().mkdirs();//创建多级目录
//}
////OutputStream是一个抽象类，所以要想实例化对象必须通过其子类来实例化对象
//        OutputStream output=new FileOutputStream(file,true);
////将第二个参数写为true，这表示我们这个文件可以进行追加，就是当我们每次写的时候都是从
////上一次的内容开始写的。如果不写第二个参数，那么默认的是false。表示这个文件不会进行追加
//        String msg="你好\n";
//        //要通过OutputStream实例化的对象调用write()方法，将内容写进文件中，需要传入的参数必须是一个字节数组
//        // 所以我们需要将内容变为字节数组，作为参数传递，将内容写进文件中。
//        output.write(msg.getBytes());
//        //关闭输出
//        output.close();



////部分内容输出
//File file = new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"a1") ;
//if(!file.getParentFile().exists()){//必须保证父目录存在
//    file.getParentFile().mkdirs();
//}
//OutputStream output=new FileOutputStream(file,true);
////下面是输出到文件的内容
//        String msg="如果巴黎不快乐";
//        //将内容变为字符数组
//        output.write(msg.getBytes());
//        output.close();
//    }
//}

//三、AutoCLoseable自动关闭支持
    //1.AutoCloseable接口的使用
//class Message implements AutoCloseable{
//    public Message(){
//        System.out.println("创建一条新消息");
//    }
//
//    @Override
//    public void close() throws Exception {
//        System.out.println("[AutoCloseable]自动关闭方法");
//    }
//    public void print(){
//        System.out.println("www.wschase.java");
//    }
//}
//public class Practice{
//    public static void main(String[] args) {
//        try(Message msg=new Message()){
//            //使用这个自动关闭就必须要在try中定义对象，并且这个对象的类都实现了AutoCloseable的接口
//            //这个异常处理和以前的不同，在try后面多了个括号；也可以写多个实例化对象，用逗号隔开。
//            msg.print();
//        }catch (Exception e){
//
//        }
//    }
//}
//2.使用自动关闭处理之前的操作
public class Practice{
    public static void main(String[] args) {
        File file =new File("E:"+File.separator+"learn"+File.separator+"javaio"+File.separator+"a1");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        //和之前输出到文件内容的操作方法不一样了。我们将定义对象这个操作方法放在了异常处理定义对象里面，
        //OutputStream是实现了AutoCloseable的接口的。
        try(OutputStream output = new FileOutputStream(file,true)){
            String msg="你和我的倾城时光";
            output.write(msg.getBytes());
            //由于我们使用了这个异常处理，所以不需要在后面写一个关闭流语句。
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

