package cn.studybigdata.java.reflect;

/**
 * @author Qingtao_Qu
 * @title: Person
 * @projectName springboot-study
 * @description: TODO
 * @date 2021/1/519:08
 */
public class Person {
    private String name;
    private int age;
    public String a;
    protected String b;
    String c;
    private String d;

    public Person(){

    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    /**
     * 私有构造器
     */
    private Person(String name){
        this.name = name;
    }

    public Person(String name, int age, String a, String b, String c, String d) {
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public void eat(){
        System.out.println("eat...");
    }
    public void eat(String food){
        System.out.println("eat:"+food);;
    }

    private void sleep(int time){
        System.out.println("sleep at "+ time +" PM");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

}
