package com.hexing.threads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created by hexing on 15-8-4.
 */
public class Sleep2 {
    public static void main(String[] args) throws InterruptedException {
        Date endDate = new Date(System.currentTimeMillis()+10*1000);
        System.out.println(endDate);
        long end = endDate.getTime();
        while (true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endDate));
            Thread.sleep(1000);
            endDate = new Date(endDate.getTime()-1000);
            if(end -10000 > endDate.getTime()){
                break;
            }
        }
    }
}
