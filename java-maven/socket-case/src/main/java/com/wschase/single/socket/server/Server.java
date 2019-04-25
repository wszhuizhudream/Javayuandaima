package com.wschase.single.socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**服务端
 * Author:WSChase
 * Created:2019/4/20
 */
public class Server {
    public static void main(String[] args) {
        //1.创建ServerSocket，监听客户端是否有连接
        //在这指定一个端口，如果有哪个客户端连接到了这个服务端的端口那么就进行通信
        try {
            ServerSocket serverSocket=new ServerSocket(6553);
            System.out.println("创建好服务器");
        //2.接收客户端连接，Socket
            Socket socket=serverSocket.accept();
            System.out.println("获取到的客户端连接："+socket.getPort());

        //3.通过Socket发送和接收数据
        //（1）接收数据
        InputStream inputStream=socket.getInputStream();
            Scanner scanner=new Scanner(inputStream);
            String message=scanner.nextLine();
            System.out.println("接收到的数据是："+message);

        //(2)发送数据
            OutputStream outputStream=socket.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            outputStreamWriter.write("你好客户端");
            outputStreamWriter.flush();

        //4.关闭ServerSocket/Socket：只要关闭了ServerSocket就没有客户端来连接了
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
