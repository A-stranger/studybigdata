package cn.studybigdata.java.reflect_ano;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        // 通过反射创建对象
        Class<?> p = Class.forName("cn.studybigdata.java.reflect_ano.Person");
        Person person = (Person) p.newInstance();

        //通过反射设置字段
        Field ageField = p.getDeclaredField("age");
        PersonAnno personAnno = ageField.getAnnotation(PersonAnno.class);
        ageField.setInt(person, personAnno.age());
        System.out.println(person.age);

        // 通过反射调用方法
        Method sayHelloMethod = p.getDeclaredMethod("sayHello");
        sayHelloMethod.invoke(person);

    }
}

@PersonAnno
class Person {
    @PersonAnno(age = 20)
    int age;

    @PersonAnno
    public void sayHello() {
        System.out.println("Hello world");
    }
}