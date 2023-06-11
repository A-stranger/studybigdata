package cn.studybigdata.java.jvm;

import java.lang.reflect.Method;

public class ClassLoaderString {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> str = ClassLoaderString.class.getClassLoader().loadClass("java.lang.String");

        for (Method method : str.getMethods()) {
            System.out.println(method);
        }
    }
}
