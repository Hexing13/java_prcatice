import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hexing on 15-7-27.
 */
public class Disease {
    public static void main(String[] args) {
        Document rootDoc = null;
        int count = 0;
        File disease = new File("/home/hexing/chendi/disease");
        FileWriter fw = null;
        try {
            fw = new FileWriter("/home/hexing/chendi/disease",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rootDoc = Jsoup.connect("http://jbk.familydoctor.com.cn/pinyin.html").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements alldisease = rootDoc.getElementsByClass("pinyin_bold");
        for(Element each:alldisease){
            try {
                fw.write(each.attr("title")+" @f NeDisease\n");
                count++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("总共%d"+count);
    }
}
