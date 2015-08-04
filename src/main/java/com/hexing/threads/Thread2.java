package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */
class Code implements Runnable
{

    @Override
    public void run() {
        for(int i = 1; i < 1000; i++)
            System.out.println("一边敲代码....!!!");
    }
}

public class Thread2 {
    public static void main(String[] args) {
        Code code = new Code();
        Thread thread = new Thread(code);
        thread.start();

        for(int i = 1; i < 1000; i++)
            System.out.println("一边听歌曲....!!!");
    }
}
