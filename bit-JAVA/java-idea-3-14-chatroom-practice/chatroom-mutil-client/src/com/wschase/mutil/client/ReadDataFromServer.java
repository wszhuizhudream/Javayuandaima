package com.wschase.mutil.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**从服务端读取数据
 * Author:WSChase
 * Created:2019/3/14
 */
public class ReadDataFromServer extends Thread{
    private final Socket client;

    public ReadDataFromServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            InputStream clientInput=client.getInputStream();
            Scanner scanner=new Scanner(clientInput);

            //虽然说是我们的服务端需要知道哪个用户需要下线了，但是我们客户端与服务端的交互也需要知道
            //因为如果他不知道的话，他就会在这个地方一直的循环，等待用户的输入，导致程序出现异常。
            while (scanner.hasNext()){
                String message=scanner.nextLine();
                System.out.println("来自服务器的消息："+message);
                //虽然说我们的客户端不需要对自己输入的消息进行判断
                //但是我们需要知道对于最后的退出，我们也需要做出反应
                //就是推出线程，因为如果不退出就会抛异常
                if(message.equals("bye")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
