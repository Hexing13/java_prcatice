package com.hexing.threads;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by hexing on 15-10-31.
 */
class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result of taskwithresult"+id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> result = new ArrayList<Future<String>>();
        for(int i = 0; i < 6; i++){
            result.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs:result){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }
}