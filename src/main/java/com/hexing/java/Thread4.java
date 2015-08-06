package com.hexing.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hexing on 15-8-6.
 */
class DisThread implements Runnable{
    private  int i = 1;
    @Override
    public void run() {
        synchronized (this){
                for(int j = 0; j < 10; j++) {
                    Document document = null;
                    try {
                        document = Jsoup.connect("http://jib.xywy.com/il_sii/gaishu/" + i++ + ".htm").get();
                    } catch (IOException e) {
                        e.printStackTrace();
                        continue;
                    }

                    Elements element = document.select(".jib-articl-con");
                    String title = element.select("strong").text();
                    title = title.substring(0, title.length() - 3);
                    String text = element.select("p").text();
                    File file = new File("/home/hexing/d/", title);
                    try {
                        FileWriter fw = new FileWriter(file);
                        fw.write(text);
                        j++;
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + title);
                }
        }
    }
}

public class Thread4 {
    public static void main(String[] args) {
        DisThread d = new DisThread();
        for(int i = 0; i < 5;i++)
            new Thread(d,"线程"+i).start();

    }
}
