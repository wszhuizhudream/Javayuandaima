package com.wschase.chatroom.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**客户端
 * Author:WSChase
 * Created:2019/3/9
 */
public class Client {
    public static void main(String[] args) {
        try {
        //1.创建Socket，指定服务器地址和服务器端口
            Socket socket=new Socket("127.0.0.0",6553);
            System.out.println("服务器地址是："+socket.getInetAddress());
        //2.通过Socket发送和接收数据
            //(1)发送数据
            OutputStream outputStream=socket.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            outputStreamWriter.write("你好服务器，我是客户端");
            outputStreamWriter.flush();
            //（2）接收数据
            InputStream inputStream=socket.getInputStream();
            Scanner scanner=new Scanner(inputStream);
            String message=scanner.nextLine();
            System.out.println("接收到服务器的数据是："+message);

        //3.关闭Socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
