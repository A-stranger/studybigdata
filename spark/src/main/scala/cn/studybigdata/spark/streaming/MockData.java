package cn.studybigdata.spark.streaming;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MockData {
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket sc = new ServerSocket(9998);

        System.out.println("等待链接... ...");
        Socket accept = sc.accept();
        System.out.println("客户端链接成功：" + accept.getLocalAddress());

        OutputStream outputStream = accept.getOutputStream();

        while (true) {

            String[] lines = new String[]{"spark", "spark spark streaming", "spark scala scala"};

            for (String line : lines) {
                String outString = line + "\n";
                System.out.println(outString);
                outputStream.write(outString.getBytes(StandardCharsets.UTF_8));
                Thread.sleep(1000);
            }
        }
    }
}