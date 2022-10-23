package cn.studybigdata.java.datatype;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class test {

    public static void main(String[] args) throws Exception {


        System.out.println("------------基本数据类型存储占用空间-----------");
        System.out.println(java.lang.Character.SIZE);
        System.out.println(Integer.SIZE); //1111 1111 1111...
        System.out.println(Long.SIZE);
        System.out.println(Float.SIZE);
        System.out.println(Double.SIZE);

//
        System.out.println("----------十进制整数、 二进制、 十六进制---------");
        int num = 97;
        int num2 = 0b1100001; // 二进制表示十进制
        int num3 = 0b110_0001;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toHexString(num));
//
//
//        System.out.println("-------------字节转其他数据类型-------------");
//        // 1.字节
        byte m = 0b01100001;
//
        int b2i = m;
        char b2c = (char) m;

        byte [] bytes = new byte[]{m};
        String b2s = new String(bytes, StandardCharsets.UTF_16BE);

        System.out.println(b2i);
        System.out.println(b2c);
        System.out.println(b2s);


        System.out.println("-------英文字符在不同字符集下的占用空间（字节数）----------");
        String a = "a";
        System.out.println(a.getBytes(StandardCharsets.US_ASCII).length);
        System.out.println(a.getBytes(Charset.forName("GB2312")).length); //英文一个字节
        System.out.println(a.getBytes(StandardCharsets.UTF_8).length);
        System.out.println(a.getBytes(StandardCharsets.UTF_16LE).length); //2-4
        System.out.println(a.getBytes(StandardCharsets.UTF_16BE).length); // 码点unicode，     码元（编码单元）
        System.out.println(a.getBytes(StandardCharsets.UTF_16).length);


        System.out.println("------中文字符在不同字符集下的占用空间（字节数）-----------");
        String jia = "甲";
        System.out.println(jia.getBytes(StandardCharsets.US_ASCII).length);
        System.out.println(jia.getBytes(Charset.forName("GB2312")).length);//中文两个字节
        System.out.println(jia.getBytes(StandardCharsets.UTF_8).length); //1-4
        System.out.println(jia.getBytes(StandardCharsets.UTF_16LE).length); //2,4
        System.out.println(jia.getBytes(StandardCharsets.UTF_16BE).length);
        System.out.println(jia.getBytes(StandardCharsets.UTF_16).length);

    }
}
