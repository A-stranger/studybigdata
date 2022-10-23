package cn.studybigdata.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectMain {

    public static void main(String[] args) throws Exception {
        Person zhangsan = new Person("张三", 18);
        Person lisi = new Person("李四", 28);
        Person wangwu = new Person("王五", 30);
        Person nobody = new Person();


        // Class对象
        // 1. 通过全限定类名
        Class personClass1 = Class.forName("cn.studybigdata.java.reflect.Person");

        // 2. 通过Person对象生成Class类的对象
        Person person = new Person();
        Class personClass2 = person.getClass();

        // 3. 通过类名.class 生成Class类的对象
        Class personClass3 = Person.class;


        // 一、拿到Field类的对象
        // 1. public属性
        Field[] fields = personClass1.getFields();
        Field a = personClass1.getField("a");
        a.set(zhangsan,"publicProperty");

        // 2. 所有在类中定义的属性(public, private, protected)
        Field[] declaredFields = personClass1.getDeclaredFields();
        Field d = personClass1.getDeclaredField("d");
        d.setAccessible(true);
        d.set(zhangsan,"d's privateProperty");


        // 二、拿到Method类的对象
        // 1. public 方法
        Method[] methods = personClass2.getMethods();

        // 1.1 无参方法
        Method eat = personClass2.getMethod("eat");
        eat.invoke(person);
        eat.invoke(zhangsan);
        eat.invoke(lisi);

        // 1.2 有参方法
        Method eatFoodMethod = personClass2.getMethod("eat", String.class);
        eatFoodMethod.invoke(zhangsan, "苹果");
        eatFoodMethod.invoke(lisi, "梨");
        eatFoodMethod.invoke(wangwu, "橘子");

        // 2. 所有在类中定义的方法
        Method[] declaredMethods = personClass2.getDeclaredMethods();

        // 2.1 私有方法
        Method sleep = personClass2.getDeclaredMethod("sleep", int.class);
        sleep.setAccessible(true);
        sleep.invoke(zhangsan,8);
        sleep.invoke(lisi,11);
        sleep.invoke(wangwu,33);


        // 三、拿到Constructor类的对象
        // 1. 有参构造函数对象
        Constructor[] constructors = personClass3.getConstructors();
        Constructor constructor = personClass3.getConstructor(String.class, int.class);
        Object 甲 = constructor.newInstance("甲", 6);

        // 2. 无参构造函数对象
        Constructor noParamContructor = personClass3.getConstructor();
        Object 乙 = noParamContructor.newInstance();

        // 3. 私有构造函数对象
        Constructor[] declaredConstructors = personClass3.getDeclaredConstructors();
        Constructor declaredConstructor = personClass3.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Object 丙 = declaredConstructor.newInstance("丙");


    }

}
