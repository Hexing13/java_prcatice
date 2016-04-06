package com.hexing.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by hexing on 16-3-7.
 */
public class ProxySubject implements InvocationHandler{
    private Object r = null;
    public ProxySubject(Object r){
        this.r = r;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("之前");
        method.invoke(r,args);
        System.out.println("之后");
        return null;
    }

    public static void main(String[] args) {
        RealSubject r = new RealSubject();
        InvocationHandler i = new ProxySubject(r);
        Class c = r.getClass();
        Subject s = (Subject) Proxy.newProxyInstance(c.getClassLoader(),c.getInterfaces(),i);
        s.request();
    }


}
