package cn.studybigdata.java.datatype;

import java.nio.charset.StandardCharsets;

//https://www.cnblogs.com/fortunely/p/14277050.html
public class Character {
    public static void main(String[] args) {

//        JAVA中其实用的是UTF-16编码
//        https://blog.csdn.net/weixin_44958119/article/details/115579329

//        为什么 Java 内部使用 UTF-16 表示字符串？
//        https://www.jianshu.com/p/957b249a02d8
//        int lowBits = 0x1D546 - 0x10000;
        int lowBits = 0x1F600 - 0x10000;
        System.out.println(Integer.toBinaryString(lowBits));

        // 由于char 的长度为 8 位，采用代理对方式表示（surrogate pair）必须使用两个 char，并使用 String 包装
        char highSurrogate = (char) ((lowBits >> 10) + 0xD800);
        char lowSurrogate = (char) ((lowBits & 0x3FF) + 0xDC00);
        String smile = new String(new char[]{highSurrogate, lowSurrogate});
        System.out.println(smile);
        System.out.println(smile.length());
        System.out.println(smile.getBytes(StandardCharsets.UTF_16LE).length);

    }
}
