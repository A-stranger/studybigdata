package cn.studybigdata.java.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketServerEasy {
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket sc = new ServerSocket(9998);

        System.out.println("等待链接... ...");
        Socket accept = sc.accept();
        System.out.println("客户端链接成功："+accept.getLocalAddress());

        OutputStream outputStream = accept.getOutputStream();

        while (true) {

            String [] lines = new String[]{"a", "b", "c", "d", "e", "f"};

            for (String line : lines) {
                String dataDate = SimpleDateFormat.getTimeInstance().format(new Date());

                String outString = dataDate +"-"+line+"\n";
                System.out.println(outString);

                outputStream.write(outString.getBytes(StandardCharsets.UTF_8));
                Thread.sleep(1000);
            }
        }
    }
}