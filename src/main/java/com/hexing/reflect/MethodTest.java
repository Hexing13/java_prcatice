package com.hexing.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by hexing on 15-8-17.
 */
public class MethodTest {
    //获取方法名
    public void show(Object o1){
        Class c1 = o1.getClass();
        Method[] methods = c1.getDeclaredMethods();
        for (Method m:methods){
            System.out.println("方法名："+m.getName());
            System.out.println("方法修饰符：" + Modifier.toString(m.getModifiers()));
            System.out.println("方法返回值："+m.getReturnType());
            Class[] classes = m.getParameterTypes();
            for (Class c:classes){
                System.out.println(c.getName());
            }

        }

    }

    //调用该方法
    public void show1(Object o1){
        Class c = o1.getClass();
        try {
            Method m0 = c.getMethod("getName",null);
            Method m = c.getMethod("setName",String.class);
            Class[] classes = {String.class,int.class};
            Method ms = c.getMethod("test",classes);
            try {
                System.out.println( m0.invoke(o1,new Object[0]));
                m.invoke(o1, "西游记");
                Object[] o = {"哈哈",888};
                System.out.println(ms.invoke(o1,o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1);
        book.setName("笑面人");
        book.setType("小说");

        MethodTest m = new MethodTest();
        m.show1(book);
        System.out.println(book.getName());
    }
}
