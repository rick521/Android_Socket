package org.example;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        ServerSocket serverSocket = new ServerSocket(12345);
        InetAddress address = InetAddress.getLocalHost();
        String ip = address.getHostAddress();
        System.out.println("服务端ip地址: " + ip);
        while (true){
            Socket socket = serverSocket.accept();//it's a waiting task
            InputStream is = socket.getInputStream();     //获取输入流
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String info;
            while((info=br.readLine())!=null){//循环读取客户端的信息
                System.out.println(info);
                br = new BufferedReader(isr);
            }
            socket.shutdownInput();//关闭输入流
            socket.close();
        }

    }
}