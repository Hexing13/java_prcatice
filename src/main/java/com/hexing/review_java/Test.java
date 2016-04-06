package com.hexing.review_java;

/**
 * Created by hexing on 15-11-19.
 */
public class Test {
    static int a = 3;
    static int b;
    static void meth(int x) {
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    static {
        System.out.println("Static block initialized.");
        b = a * 4;
    }
    public static void main(String args[]) {
        meth(42);
    }
}
//public class Test {
//    public static int value = 3;
//    public void print(){
//        int value = 2;
//        System.out.println(this.value);
//    }
//    public static void main(String[] args) {
//        new Test().print();
//    }
//}
//public class Test {
//    Person1 person = new Person1("Test");
//    static{
//        System.out.println("test static");
//    }
//
//    public Test() {
//        System.out.println("test constructor");
//    }
//
//    public static void main(String[] args) {
//        new MyClass();
//    }
//}
//
//class Person1{
//    static{
//        System.out.println("person static");
//    }
//    public Person1(String str) {
//        System.out.println("person "+str);
//    }
//}
//
//
//class MyClass extends Test {
//    Person1 person = new Person1("MyClass");
//    static{
//        System.out.println("myclass static");
//    }
//
//    public MyClass() {
//        System.out.println("myclass constructor");
//    }
//}