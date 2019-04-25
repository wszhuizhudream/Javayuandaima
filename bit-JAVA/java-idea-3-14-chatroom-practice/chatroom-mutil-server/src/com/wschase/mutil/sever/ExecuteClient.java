package com.wschase.mutil.sever;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**处理与服务器与客户端的交互——实现Runnble接口成为一个线程
 * Author:WSChase
 * Created:2019/3/14
 */
public class ExecuteClient implements Runnable {
   //首先建立一个集合，用来存放客户端以及客户端的信息
    //ConcurrentHashMap可以处理线程的并发——并且我们希望我们的这个集合一直不会被改变
   private static final Map<String,Socket> ONLINE_USER_CLIENT=new ConcurrentHashMap<>();

Queue<Integer>
    //定义变量——当前在线用户
    private final Socket currentClient;//这个用户就是后面我们需要对他进行一系列操作的用户

    public ExecuteClient(Socket currentClient) {
        this.currentClient=currentClient;
    }

    //在run方法中实现业务功能
    @Override
    public void run() {

        try {
        //1.我们需要获得客户端的输入，并且将我们的输入流转化为字符流
            InputStream clientInput=this.currentClient.getInputStream();
            //将这个输入流转化为字符流
            Scanner scanner=new Scanner(clientInput);
        //我们需要一直等待用户的输入
        while (true){
            //按行读取、按行解析
            String line=scanner.nextLine();

            /*
            1.注册：userName:<name>
            2.私聊：private:<name>:message
            3.群聊：group:message
            4.退出：bye
             */

        //当用户输入以后，我们就根据用户的输入进行判断它想要实现什么样的功能

            //1.注册
            if(line.startsWith("userName")){
                //注册功能
                String userName=line.split("\\:")[1];
                this.register(userName,currentClient);
                continue;
            }

            //2.私聊
            if(line.startsWith("private")){
                String[] segments=line.split("\\:");
                String userName=segments[1];
                String message=segments[2];
                this.privateChat(userName,message);
                continue;
            }

            //3.群聊
            if(line.startsWith("group")){
                String message=line.split("\\:")[1];
                this.groupChat(message);
                continue;
            }

            //4.退出
            if(line.startsWith("bye")){
                this.quit();
                break;
            }


        }




        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    //对于每一个功能我们都有响应的方法

    //4.退出功能

    /*
    分析：
    （1）获取当前客户的客户名
    （2）在服务端打印一下用户下线的消息
    （3）根据用户名将用户从集合中移除
    （4）给客户端发送消息
    （5）再打印一下当前在线的人数
     */
    private void quit() {
        String currentUserName=this.getCurrentUserName();
        System.out.println(currentUserName+"用户下线");
        Socket socket=ONLINE_USER_CLIENT.remove(currentUserName);
        this.sendMessage(socket,currentUserName+"你已下线！");
        printOnlineUsers();


    }


    //3.群聊功能

    /*
    分析：
    （1)遍历集合的values，如果不是自己这个对象就将消息返回到客户端
     */

    private void groupChat(String message) {
        for(Map.Entry<String,Socket> entry:ONLINE_USER_CLIENT.entrySet()){//这个地方表示所有的客户
            if(entry.getValue().equals(this.currentClient)){
                continue;
            }
            //但是在发送消息的时候，要排除自己
            this.sendMessage(entry.getValue(),message);
        }

    }


    //2.私聊功能

    /*
    分析：
    （1）获取当前用户名
    （2）根据传进来的目标对象名字获取这个目标对象（根据key获取value）
    （3）如果当前对象不为空，就向目标客户端返回消息
     */
    private void privateChat(String userName, String message) {
        //获取当前客户的名称是为了要告诉目标对象是谁给它发送的消息
        String currentUserName=this.getCurrentUserName();

        //获取目标对象，是因为在给客户发送消息的时候我们需要知道这个客户是谁
        Socket targetUser=ONLINE_USER_CLIENT.get(userName);
        if(currentClient!=null){
            this.sendMessage(targetUser,currentUserName+"对你说"+message);
        }
    }



    //1.注册功能
    /*
    分析：
    (1)首先在服务器端打印一下此时谁已经连接到服务器
    (2)注册功能我们需要将客户装进集合里面
    (3)我们打印一下目前的用户在线人数
    (4)我们向用户返回一个消息：告诉用户它已经注册成功
     */
    private void register(String userName, Socket currentClient) {
        System.out.println(userName+"加入到聊天室"+currentClient);

        ONLINE_USER_CLIENT.put(userName,currentClient);

        printOnlineUsers();

        //需要传入两个参数，第一个是客户用来获取它的输出流、第二个是需要传到客户端的消息
        sendMessage(this.currentClient,userName+"注册成功！");
    }


    //获取当前用户名
    /*
    分析：
    通过在集合里面遍历找到和当前用户相同的客户，通过键值对的方式获取当前用户的名字
     */
    private String getCurrentUserName() {
        String currentUserName="";

        for(Map.Entry<String,Socket> entry:ONLINE_USER_CLIENT.entrySet()){
            if(this.currentClient.equals(entry.getValue())){
                currentUserName=entry.getKey();
                //当找到与当前socket相等的socket时就需要终止循环
                break;
            }
        }
        return currentUserName;
    }

    //向客户端发送消息
    /*
    分析：
    （1）首先需要创建输出流
    （2）将输出流转化为字符流
     */
    private void sendMessage(Socket socket, String message) {
        try {
            OutputStream clientOutput=socket.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(clientOutput);
            outputStreamWriter.write(message+"\n");
            outputStreamWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //打印当前在线的用户
    /*
    分析：
    （1）首先打印总的在线人数
    （2)遍历集合将具体的当前在线用户名打印出来
     */
    private static void printOnlineUsers() {
        System.out.println("当前在线人数："+ONLINE_USER_CLIENT.size()+"具体情况如下：");

        for(Map.Entry<String,Socket> entry:ONLINE_USER_CLIENT.entrySet()){
            System.out.println(entry.getKey());
        }

    }
}
