package com.hexing.threads;

/**
 * Created by hexing on 15-8-5.
 */

class JvmThread extends Thread{
    private long time;
    public JvmThread(){}
    public JvmThread(long time){
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+": "+Jvm.getJvm(time));
    }
}
public class Singl {
    public static void main(String[] args) {
//        Jvm j1 = Jvm.getJvm(122);
//        System.out.println(j1);
//        Jvm j2 = Jvm.getJvm(300);
//        System.out.println(j2);
        JvmThread jvmThread = new JvmThread(123);
        JvmThread jvmThread1 = new JvmThread(456);
        jvmThread.start();
        jvmThread1.start();
        System.out.println(jvmThread);
        System.out.println(jvmThread1);
    }
}

class Jvm {
    private static Jvm jvm = null;

    private Jvm() {

    }

    public static Jvm getJvm(long time) {
        if (jvm == null) {
            synchronized (Jvm.class) {
                if (jvm == null) {
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    jvm = new Jvm();
                }
            }
        }
        return jvm;
    }


}