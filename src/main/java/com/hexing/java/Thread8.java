package com.hexing.java;

/**
 * Created by hexing on 15-8-7.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by hexing on 15-8-7.
 */

class two implements Runnable{
    private static int i = 0;
    private static int count = 1;

    @Override
    public void run() {
            int num;
            synchronized (this){
                i++;
                num = i;
            }

            Document document = null;
            Document document1 = null;
            try {
                document = Jsoup.connect("http://jib.xywy.com/il_sii/gaishu/" + num + ".htm").timeout(10000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                document1 = Jsoup.connect("http://jib.xywy.com/il_sii/symptom/" + num + ".htm").timeout(10000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements element = document.select(".jib-articl-con");
            String text = element.select("p").text();

            Elements elements = document1.select(".jib-articl");
            Elements allp = elements.select("p");
            File file = new File("/home/hexing/m",String.valueOf(count++));
            try {
                FileWriter fw = new FileWriter(file);
                fw.write(text+'\n'+'\n');
                for(Element p:allp){
                    fw.write(p.text()+'\n'+'\n');
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

public class Thread8 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for(int i = 0; i < 10136;i++){
            service.submit(new two());
        }

    }
}
