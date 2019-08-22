package sever;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**服务器：等待用户连接
 * Author:WSChase
 * Created:2019/3/14
 */
public class MutilThreadServer {
    public static void main(String[] args) {

        //首先我们需要创建一个线程池来装这些客户(假如我们指定一次性线程池中只能装下15个客户进行与服务器的交互)
       final ExecutorService executorService=Executors.newFixedThreadPool(15);

        try {
            //创建服务器的Socket，去接收客户端的socket，与客户端进行连接
            ServerSocket serverSocket=new ServerSocket(6666);
            System.out.println("等待用户的连接：");


            //我们这个是多线程版本，所以进来一个客户端我们的服务器就需要连接一个
            //所以我们用循环对客户端一直进行监听
            while (true){

                //进来一个客户端我们就与服务器进行连接
            Socket client=serverSocket.accept();
            //当客户端与服务器进行连接以后就需要进行对服务器进行传输信息，进行交互
            //但是这个交互我们通过一个线程来完成，它处于阻塞状态，只有当客户端发送消息之后才会
            //执行操作，否则就是一直等待的状态。
                executorService.submit(new ExecuteClient(client));

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
