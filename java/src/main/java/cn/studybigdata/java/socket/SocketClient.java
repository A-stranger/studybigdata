package cn.studybigdata.java.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class SocketClient extends Socket {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9999);
        InputStream inputStream = socket.getInputStream(); //字节流
        byte[] bytes = new byte[8];
        int read = inputStream.read(bytes);
        String in = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(in);

    }
}