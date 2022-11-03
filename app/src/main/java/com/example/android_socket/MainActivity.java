package com.example.android_socket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.*;
import java.net.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread() {
            @Override
            public void run() {
                try {
                    acceptServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
    private void acceptServer() throws IOException {
        //1.创建客户端Socket，指定服务器地址和端口
        Socket socket = new Socket("10.32.108.182", 12345);
        //2.获取输出流，向服务器端发送信息
        OutputStream os = socket.getOutputStream();//字节输出流
        PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流
        pw.write("客户端：hello");
        pw.flush();
        socket.shutdownOutput();//关闭输出流
        socket.close();
    }
}