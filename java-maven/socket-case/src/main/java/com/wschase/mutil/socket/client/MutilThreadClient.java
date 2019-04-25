package com.wschase.mutil.socket.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Stack;

/**客户端和服务端进行交互
 * Author:WSChase
 * Created:2019/4/20
 */
public class MutilThreadClient {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",6666);
            new ReadDataFrontServer(socket).start();
            new WriteDataToServer(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
