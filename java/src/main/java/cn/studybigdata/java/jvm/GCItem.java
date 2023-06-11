package cn.studybigdata.java.jvm;

import java.util.ArrayList;

public class GCItem {

    byte[] a = new byte[1024*100]; //100KB
    public static void main(String[] args) throws InterruptedException {
        ArrayList<GCItem> items = new ArrayList<>();
        while (true){
            items.add(new GCItem());
            Thread.sleep(10);
        }
    }
}
