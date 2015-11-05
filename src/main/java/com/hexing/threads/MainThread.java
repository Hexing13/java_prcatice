package com.hexing.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hexing on 15-10-31.
 */
public class MainThread {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 6; i++){
           exec.execute(new LiftOff());
        }
        System.out.println("waiting");
    }
}
