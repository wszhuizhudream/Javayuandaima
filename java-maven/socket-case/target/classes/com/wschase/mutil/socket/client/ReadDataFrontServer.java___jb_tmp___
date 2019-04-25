package com.wschase.mutil.socket.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**从服务端读取数据
 * Author:WSChase
 * Created:2019/4/20
 */
public class ReadDataFrontServer extends Thread{
    private final Socket client;

    public ReadDataFrontServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            InputStream clientInput=client.getInputStream();
            Scanner scanner=new Scanner(clientInput);

            while(scanner.hasNext()){
                String message=scanner.nextLine();
                System.out.println("来自服务器的消息："+message);
                if(message.equals("bye")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
