package cn.studybigdata.java.serialize;

import java.io.Serializable;

/**
 * Java中的transient关键字，transient是短暂的意思。对于transient 修饰的成员变量，在类实例的序列化处理过程中会被忽略。
 * 因此，transient变量不会贯穿对象的序列化和反序列化，生命周期仅存于调用者的内存中而不会写到磁盘里持久化。
 */
public class Student implements Serializable {
    private String name;
    private String sex;
    private String address;
    private String phoneNumber;
    private transient String emotion;

    public Student(String name, String sex, String address, String phoneNumber, String emotion) {
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emotion = emotion;
    }
    public void say(){
        System.out.println("高兴死了，我来到了这个世界上~~~");
    }
    public void sayAgain(){
        System.out.println("我又活过来了~~~");
    }
}
