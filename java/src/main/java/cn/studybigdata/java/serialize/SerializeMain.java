package cn.studybigdata.java.serialize;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 */
public class SerializeMain {
    public static void main(String[] args) throws IOException {

        Student zhangsan = new Student("zhangsan","male", "山东省泰安市岱岳区山东财经大学东方学院","18888888888","happy");
        zhangsan.say();
        System.out.println("-----------");

        FileOutputStream file = new FileOutputStream("D:\\IdeaProjects\\hadoop-train\\data\\zhangsan.stu");
        ObjectOutputStream oos = new ObjectOutputStream(file);

        oos.writeObject(zhangsan);
        oos.close();
        file.close();
        System.out.println("张三被保存到zhangsan.stu文件中了");

    }

}
