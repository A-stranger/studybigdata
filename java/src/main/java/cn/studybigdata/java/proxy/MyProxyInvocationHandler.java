package cn.studybigdata.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyProxyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==========================");
        method.invoke(target);
        System.out.println("==========================");
        return null;
    }
}
