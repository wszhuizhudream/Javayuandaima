package com.wschase.mutil.socket.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**向服务器写数据
 * Author:WSChase
 * Created:2019/4/20
 */
public class WriteDataToServer extends Thread{
    private final Socket client;

    public WriteDataToServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            OutputStream clientOutput=client.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(clientOutput);
            //提示用户输入
            System.out.println("欢迎使用迷你聊天室[使用提示]\n" +
                    "            1.注册：userName:<name>\n" +
                    "            2.私聊：private:<name>:message\n" +
                    "            3.群聊：group:message\n" +
                    "            4.退出：bye");

            //注意：向服务端写入数据的是我们用户从界面输入的
            Scanner scanner=new Scanner(System.in);
            while (true){
                System.out.println("请输入消息：");
                String message=scanner.nextLine();
                outputStreamWriter.write(message);
                outputStreamWriter.flush();

                if(message.equals("bye")){
                    //关闭客户端
                    client.close();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
