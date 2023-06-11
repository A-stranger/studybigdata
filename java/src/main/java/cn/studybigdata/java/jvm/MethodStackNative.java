package cn.studybigdata.java.jvm;

public class MethodStackNative {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        // start 会调用 native方法 start0();
    }
}
