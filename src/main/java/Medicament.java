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
public class Medicament {
    public static void main(String[] args) {
        Document rootDoc = null;
        int count = 0;
        File medicament = new File("/home/hexing/chendi/medicament");
        FileWriter fw = null;
        try {
            fw = new FileWriter(medicament,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rootDoc = Jsoup.connect("http://ypk.familydoctor.com.cn/pinyin.html").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements alldisease = rootDoc.getElementsByClass("pinyin_bold");
        for(Element each:alldisease){
            try {
                fw.write(each.attr("title")+" @f NeMedicament\n");
                count++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fw.write("总共"+count+"个\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
