package com.wschase.single.socket.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**客户端
 * Author:WSChase
 * Created:2019/4/20
 */
public class Client {
    public static void main(String[] args) {
        //1.创建Socket对象，指定服务器的地址和服务器端口
        try {
            //表示创建一个套接字并将其连接到指定的书记的指定端口号上
            Socket socket=new Socket("localhost",6553);
            System.out.println("连接服务的地址是："+socket.getInetAddress());
        //2.通过Socket发送和接收数据
        //（1）在客户端的先发送数据
            //获取到当前客户端的输出流
            OutputStream outputStream=socket.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            outputStreamWriter.write("你好服务器");
            //写完以后需要刷新输出流
            outputStreamWriter.flush();

        //（2）接收数据
            InputStream inputStream=socket.getInputStream();
            Scanner scanner=new Scanner(inputStream);
            String message=scanner.nextLine();
            System.out.println("接收到服务器的数据："+message);


        //3.关闭Socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
