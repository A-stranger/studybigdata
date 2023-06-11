package cn.studybigdata.scala.oop.obj.companion.java;

public class Dog {
    public static int primarykey = 0;

    private int id = 0;
    private String name = null;

    public Dog(String name){
        primarykey += 1 ;
        this.id = primarykey;
        this.name = name;
    }

    public static void main(String[] args) {

        Dog chineseRuralDog = new Dog("中华田园犬");
        System.out.println(chineseRuralDog.id + "\t" + chineseRuralDog.name );
        Dog goldenHairDog = new Dog("金毛");
        System.out.println(goldenHairDog.id + "\t" + goldenHairDog.name);
    }
}
