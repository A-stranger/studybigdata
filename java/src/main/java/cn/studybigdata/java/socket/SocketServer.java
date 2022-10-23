package cn.studybigdata.java.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketServer {
    public static void main(String[] args) throws IOException, InterruptedException {

//        ServerSocket sc = new ServerSocket(9999);
//        Socket accept = sc.accept();
//        OutputStream outputStream = accept.getOutputStream();
//        byte[] achar = "hello".getBytes(StandardCharsets.UTF_8);
//
//        outputStream.write(achar);
        writeFile();

    }

    public static void writeFile() throws IOException {

        String tmp = "abc";
        String tmp2 = "cde";
        File file = new File("D:\\a.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);


        outputStream.write(tmp2.getBytes(StandardCharsets.UTF_8));
        outputStream.write(tmp.getBytes(StandardCharsets.UTF_8));
    }
}