package cn.studybigdata.java.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("D:\\IdeaProjects\\hadoop-train\\data\\zhangsan.stu");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Student o = (Student) ois.readObject();

        o.sayAgain();

        ois.close();
        fis.close();
        System.out.println("-------------");

    }
}
