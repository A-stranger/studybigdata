package cn.studybigdata.java.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class StreamingHelloWorld {
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket sc = new ServerSocket(9997);

        System.out.println("等待链接... ...");
        Socket accept = sc.accept();
        System.out.println("客户端链接成功："+accept.getLocalAddress());

        OutputStream outputStream = accept.getOutputStream();

        while (true) {

            String [] lines = new String[]{"a", "b", "c", "d", "e", "f"};

            for (String line : lines) {

                // 输出数据最后一定要有换行符！！！，不然spark收不到数据。
                line = line + "\n";
                System.out.println("输出字符： "+ line);

                outputStream.write(line.getBytes(StandardCharsets.UTF_8));
                Thread.sleep(500);
            }
        }
    }
}