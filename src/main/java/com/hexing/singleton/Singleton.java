package com.hexing.singleton;

/**
 * Created by hexing on 15-11-16.
 */
public class Singleton {
//    //懒汉式
//    private volatile static Singleton singleton = null;
//    private Singleton(){}
//    private static Singleton getInstance(){
//        if(singleton==null){
//            synchronized (Singleton.class){
//                if(singleton==null){
//                    singleton = new Singleton();
//                }
//                return singleton;
//            }
//        }
//        return singleton;
//    }
    //饿汉式
    private static class Inner{
        private static final Singleton sigleton = new Singleton();
    }
    private Singleton(){}
    public static Singleton getInstance(){
        return Inner.sigleton;
    }
    @Override
    public String toString() {
        return "singleton";
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
    }
}
