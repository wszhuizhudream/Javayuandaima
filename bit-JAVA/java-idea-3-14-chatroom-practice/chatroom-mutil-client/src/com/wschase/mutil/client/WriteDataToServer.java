package com.wschase.mutil.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**向服务端写数据
 * Author:WSChase
 * Created:2019/3/14
 */
public class WriteDataToServer extends Thread{
    private final Socket client;

    public WriteDataToServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream=client.getOutputStream();
            OutputStreamWriter writer=new OutputStreamWriter(outputStream);

                //注意：这个地方向服务端写入的数据是用户从界面输入的数据
                Scanner scanner=new Scanner(System.in);
            while (true){
                System.out.println(" 1.注册：userName:<name>\n" +
                        "            2.私聊：private:<name>:message\n" +
                        "            3.群聊：group:message\n" +
                        "            4.退出：bye");
                System.out.println("请输入消息：");
                String message=scanner.nextLine();
                //注意：在给服务器发完消息以后一定要记得加上"\n",因为在服务器读取数据的时候是按照行来读取的
                //如果没有换行符，那么它不知道用户已经完成了输入，这样在服务器就不会进行处理，结果自然也就不对了。
                writer.write(message+"\n");
                writer.flush();


                //在这个地方我们同样需要进行判断，用户的输入如果是bye，我们就需要终止整个线程
                if(message.equals("bye")){
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
