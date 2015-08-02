package com.hexing.java;

/**
 * Created by hexing on 15-7-30.
 */
class ss
{
    private int count;
    public int add(){
        synchronized (this){
            count = count+1;
            return count;
        }
    }
}

class Mythread extends Thread
{
    private ss sd;
    private int sum;
    private int a[] = new int[10];
    public Mythread(String name,ss sd){
        super(name);
        this.sd = sd;
    }

    public void run(){
        for (int i = 0; i < 10;i++){
            a[i] = sd.add();
            sum += a[i];
            try {
                Mythread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("累加和："+sum);
    }

    public void show(){
        System.out.print(getName()+"获得数为：");
        for (int i = 0; i < 10; i++){
            System.out.print(a[i]+" + ");
        }
        System.out.println(" = "+sum);
    }
}
public class th2 {
    public static void main(String[] args) {
        Thread th = Thread.currentThread();
        ss sd = new ss();
        for(int i = 1; i <= 3; i++){
            new Mythread(String.valueOf(i),sd).start();
        }

        System.out.println("wancheng");
    }

}
