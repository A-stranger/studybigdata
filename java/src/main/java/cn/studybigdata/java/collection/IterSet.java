package cn.studybigdata.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IterSet {
    public static void main(String[] args) {
        Collection books = new ArrayList();
        books.add("Hadoop");
        books.add("HBase");
        books.add("Linux");

        Iterator it = books.iterator();

        while (it.hasNext()){
            String book = (String) it.next();
            System.out.println(book);

            if ("Linux".equals(book)){
//                it.remove(); 可删除
//                books.remove("Hadoop");  // 删除元素后，Set大小变了，再次取值就失败了
                books.remove("Linux"); // 删除最后一个元素，则不会出错
            }
        }
        System.out.println(books);
    }
}
