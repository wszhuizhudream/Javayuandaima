package com.wschase.chatroom.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**服务端
 * Author:WSChase
 * Created:2019/3/8
 */
public class Server {
    public static void main(String[] args) {
        try {
        //1.创建ServletSocket，绑定端口
            ServerSocket serverSocket=new ServerSocket(6553);
            System.out.println("创建好服务器");
        //2.接收客户端连接，Socket
            Socket socket =serverSocket.accept();
            System.out.println("接收客户连接"+socket.getPort());
        //3.通过Socket发送和接收数据
            //（2）发送数据
            OutputStream outputStream=socket.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            outputStreamWriter.write("你好，我是服务器\n");
            outputStreamWriter.flush();
            //(1)接收数据
            InputStream inputStream=socket.getInputStream();
            Scanner scanner=new Scanner(inputStream);
            String message=scanner.nextLine();
            System.out.println("接收数据:"+message);
        //4.关闭ServerSocket/Socket
            serverSocket.close();
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
