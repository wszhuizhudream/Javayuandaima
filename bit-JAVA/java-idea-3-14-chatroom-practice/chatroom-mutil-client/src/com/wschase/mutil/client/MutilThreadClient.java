package com.wschase.mutil.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**客户端
 * Author:WSChase
 * Created:2019/3/14
 */
public class MutilThreadClient {
    public static void main(String[] args) {
        //创建socket
        try {
            Socket socket=new Socket("127.0.0.1",6666);

            new ReadDataFromServer(socket).start();
            new WriteDataToServer(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
