package cn.studybigdata.java.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketServerA {
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket sc = new ServerSocket(9999);

        System.out.println("等待链接... ...");
        Socket accept = sc.accept();
        System.out.println("客户端链接成功："+accept.getLocalAddress());
        OutputStream outputStream = accept.getOutputStream();

        while (true) {
            String [] characters = {"a","b","c"};
            for (String character : characters) {
                String value = character+"\n";
                outputStream.write(value.getBytes(StandardCharsets.UTF_8));
                System.out.println("输出字符： "+ value);
                Thread.sleep(1000);
            }
        }
    }
}