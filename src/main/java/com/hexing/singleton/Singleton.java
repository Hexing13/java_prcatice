package com.hexing.singleton;

/**
 * Created by hexing on 15-11-16.
 */
public class Singleton {
    //饿汉式
//    private static final Singleton singleton = new Singleton();
    //懒汉式
//    private volatile static Singleton singleton = null;
//    private Singleton(){}
//    public static Singleton getInstance(){
//        if(singleton==null){
//            synchronized (Singleton.class){
//                if(singleton==null){
//                    return new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
    //饿汉式更改
    private static class SingltonHolder{
        private static final Singleton singleton = new Singleton();
    }
    private Singleton(){}
    public static Singleton getInstance(){
        return SingltonHolder.singleton;
    }
    @Override
    public String toString() {
        return "singleton";
    }
}
