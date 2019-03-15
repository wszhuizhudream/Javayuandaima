package com.wschase.chatroom.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**服务器
 * Author:WSChase
 * Created:2019/3/9
 */
public class Server {
    public static void main(String[] args) {
        try {
        //1.创建ServerSocket，绑定端口
            ServerSocket serverSocket=new ServerSocket(6553);
        //2.接收客户端连接，Socket
            Socket socket=serverSocket.accept();
        //3.通过Socket发送和接收数据
            InputStream inputStream=socket.getInputStream();
            Scanner scanner=new Scanner(inputStream);
            String meaasge=scanner.nextLine();
            System.out.println("接收到客户端的数据是："+meaasge);

            OutputStream outputStream=socket.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            outputStreamWriter.write("你好客户端，我是服务器");
            outputStreamWriter.flush();
        //4.关闭ServerSocket
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
