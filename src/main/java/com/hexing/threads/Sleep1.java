package com.hexing.threads;

/**
 * 倒数数１０个数
 * Created by hexing on 15-8-4.
 */
public class Sleep1 {
    public static void main(String[] args) {
        int num = 10;
        while (true){
            System.out.println(num--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(num <= 0){
                break;
            }
        }
    }
}
