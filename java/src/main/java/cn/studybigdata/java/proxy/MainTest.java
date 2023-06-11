package cn.studybigdata.java.proxy;

import java.lang.reflect.Proxy;

public class MainTest {
    public static void main(String[] args) {

        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Mapper target = new MyMapper();

        MyProxyInvocationHandler invocationHandler = new MyProxyInvocationHandler(target);

        Mapper proxyMapper  = (Mapper) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Mapper.class}, invocationHandler);
        proxyMapper.insert();

    }
}
