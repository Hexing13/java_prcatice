package com.hexing.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by hexing on 15-8-17.
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
//        Class demo1 = null;
//        Class demo2 = null;
        Class demo3 = null;
//
//        try {
//            demo1 = Class.forName("com.hexing.reflect.Book");
//            System.out.println("对象一："+demo1);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Book bo = new Book();
//        Object ob = bo;
//        System.out.println("对象二："+ob.getClass());

        demo3 = Book.class;
//        System.out.println("对象三："+demo3);
//        System.out.println(demo3.getSuperclass());
//        System.out.println(demo3.getPackage());
        Constructor[] constructors = demo3.getConstructors();
        System.out.println(constructors.length);
        try {
            Book b = (Book) constructors[0].newInstance();
            System.out.println(b.getName());
            Book b1 = (Book) constructors[1].newInstance("aaa");
            System.out.println(b1.getName());
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            Book b = (Book) demo3.newInstance();
            System.out.println(b);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
