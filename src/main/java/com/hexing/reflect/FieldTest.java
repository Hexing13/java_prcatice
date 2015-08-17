package com.hexing.reflect;

import java.lang.reflect.Field;

/**
 * Created by hexing on 15-8-17.
 */
public class FieldTest {
    //接受传递的Class对象，获取相应的属性
    public void show(Class c1){
        Field[] fs = c1.getDeclaredFields();//能获取私有属性
        for (Field f:fs){
            System.out.println(f.getName()+"  "+f.getType());
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        Field[] fi = c1.getFields();//不能获取私有对象
        for (Field f:fi){
            System.out.println(f.getName()+"  "+f.getType());
        }
    }

    //接受传递进来的实体类对象，并获取属性及其值
    public void show1(Object o1){
        Class c1 = o1.getClass();
        Field[] fs = c1.getDeclaredFields();
        for (Field f:fs){
            try {
                f.setAccessible(true);//设置启用
                System.out.println(f.getName()+"  "+f.get(o1));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1);
        book.setName("笑面人");
        book.setType("小说");

        FieldTest f = new FieldTest();
        f.show1(book);
    }
}
