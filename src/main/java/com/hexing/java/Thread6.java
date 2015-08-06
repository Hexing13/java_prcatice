package com.hexing.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hexing on 15-8-6.
 */
class SymThread extends Thread{
    private static int i = 1;
    @Override
    public void run(){
        for(int j = 0; j < 200; j++){
            Document document = null;
            try {
                document = Jsoup.connect("http://jib.xywy.com/il_sii/symptom/" + i++ + ".htm").get();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            Elements elements = document.select(".jib-articl");
            String title = elements.select(".tc").text();
            Elements allp = elements.select("p");
            File file = new File("/home/hexing/symptom",title);
            try {
                FileWriter fw = new FileWriter(file);
                for(Element p:allp){
                    fw.write(p.text()+'\n'+'\n');
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
public class Thread6 {
    public static void main(String[] args) {
        for(int i = 0; i < 52;i++){
            new SymThread().start();
        }
    }
}
