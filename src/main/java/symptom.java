/**
 * Created by hexing on 15-7-27.
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.*;

/**
 * Created by hexing on 15-7-27.
 */
public class symptom {
    public static void main(String[] args) {
        Document rootDoc = null;
        File symptom = new File("/home/hexing/chendi/symptom");
        FileWriter fw = null;
        try {
            fw = new FileWriter("/home/hexing/chendi/symptom",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rootDoc = Jsoup.connect("http://zzk.familydoctor.com.cn/pinyin.html").get();
            System.out.println(rootDoc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements allsymp = rootDoc.select("a");
        for(Element each:allsymp){
            try {
                if(each.attr("title") == null){
                    continue;
                }
                fw.write(each.attr("title")+" @f Nesymptom\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

