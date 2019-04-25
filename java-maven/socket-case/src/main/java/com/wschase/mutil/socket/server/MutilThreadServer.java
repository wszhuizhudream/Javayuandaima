package com.wschase.mutil.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**服务器：等待用户连接
 * Author:WSChase
 * Created:2019/4/20
 */
public class MutilThreadServer {
    public static void main(String[] args) {
        //我们采用日志的方式打印信息


        //创建一个线程池来装这些客户
        final ExecutorService executorService=Executors.newFixedThreadPool(15);

        try {
            ServerSocket serverSocket=new ServerSocket(6666);
            System.out.println("等待用户连接：");

            //这个是多线程版本所以进来一个客户我们就需要创建一个它对应的socket与之进行通信
            while (true){
                Socket client=serverSocket.accept();

                //客户端和服务端取得连接以后就要进行通信，但是我们这个过程通过线程来完成，所以它
                //一直处于阻塞状态:线程只是将每个客户端和服务端需要进行通信的任务进行了提交
                executorService.submit(new ExecuteCilent(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
