package com.wschase.mutil.socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**处理服务器于客户端之间的交互——这个是最重要的一个部分
 * 通过多线程的方法我们将真正交互取得连接分离开了
 * Author:WSChase
 * Created:2019/4/20
 */
public class ExecuteCilent implements Runnable{
    //首先建立一个集合用来存放客户端以及客户端的信息
    //注意：ConcurrentHashMp可以处理线程的并发——并且我们希望这个集合不会被改变
    private static final Map<String,Socket> ONLINE_USER_CLIENT=new ConcurrentHashMap<String, Socket>();

    //定义变量——当前在线用户
    private final Socket currentCilent;

    public ExecuteCilent(Socket currentCilent) {
        this.currentCilent = currentCilent;
    }


    public void run() {

        //1.我们需要获取客户端的输入，并且将我们的输入流转化为字符流
        try {
            InputStream clientInput=this.currentCilent.getInputStream();
            Scanner scanner=new Scanner(clientInput);

            //我们需要一直等待用户的输入
            while(true){
                String line=scanner.nextLine();

                //等待用户输入以后我们需要根据用户的输入判断用户需要执行什么样的功能
                /**
                 * 功能：
                 * 1.注册：userName:<name>
                 * 2.私聊：private:<name>:message
                 * 3.群聊：group:message
                 * 4.退出：bye
                 */
                //当用户输入以后我们根据根据用户的输入判断它要执行的功能
                //1.注册
                if(line.startsWith("userName")){
                    //注册功能
                    String userName=line.split("\\:")[1];
                    this.register(userName,currentCilent);
                    continue;
                }
                //2.私聊
                if(line.startsWith("private")){
                    String[] segment=line.split("\\:");
                    String userName=segment[1];
                    String message=segment[2];
                    this.privateChat(userName,message);
                    continue;
                }
                //3.群聊
                if(line.startsWith("group")){
                    String messqge=line.split("\\:")[1];
                    this.groupChat(messqge);
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

    /**
     * 4.退出功能
     */
    private void quit() {
        String currentUserName=this.getCurrentUserName();
        System.out.println(currentUserName+"用户下线");
        Socket socket=ONLINE_USER_CLIENT.remove(currentUserName);
        this.sendMessage(socket,currentUserName+"你已经下线");
        printOnlineUsers();

    }


    /**
     * 3.群聊功能
     * @param messqge
     */
    private void groupChat(String message) {

        //自己不给自己发送消息
        for(Map.Entry<String,Socket> entry:ONLINE_USER_CLIENT.entrySet()){
            if(entry.getValue().equals(this.currentCilent)){
                continue;
            }

            this.sendMessage(entry.getValue(),message);
        }
    }

    /**
     * 2.私聊功能
     * @param userName
     * @param message
     */

    private void privateChat(String userName, String message) {
        String currentUserName=this.getCurrentUserName();
        Socket targetUser=ONLINE_USER_CLIENT.get(userName);
        if(currentUserName!=null){
            this.sendMessage(targetUser,currentUserName+"对你说："+message);
        }

    }


    /**
     * 1.注册功能
     * @param userName
     * @param currentCilent
     */
    private void register(String userName, Socket currentCilent) {
        System.out.println(userName+"加入到聊天室"+currentCilent);

        ONLINE_USER_CLIENT.put(userName,currentCilent);

        printOnlineUsers();

        sendMessage(this.currentCilent,userName+"注册成功");
    }

    //发送消息
    private void sendMessage(Socket currentCilent, String s) {
        try {
            OutputStream clientOutput=currentCilent.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(clientOutput);
            outputStreamWriter.write(s);
            outputStreamWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //打印当前在线的用户
    private void printOnlineUsers() {
        System.out.println("当前在线人数："+ONLINE_USER_CLIENT.size()+"具体情况如下：");

        for(Map.Entry<String,Socket> entry:ONLINE_USER_CLIENT.entrySet()){
            System.out.println(entry.getKey());
        }
    }

    //获取当前用户名
    private String getCurrentUserName(){
        String currentUserName="";
        for(Map.Entry<String,Socket> entry:ONLINE_USER_CLIENT.entrySet()){
            if(this.currentCilent.equals(entry.getValue())){

            currentUserName=entry.getKey();
            break;
            }
        }

        return currentUserName;
    }
}
