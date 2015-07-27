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
public class Factory {
    public static void main(String[] args) {
        Document rootDoc = null;
        int count = 0;
        File factory = new File("/home/hexing/chendi/factory");
        FileWriter fw = null;

        try {
            fw = new FileWriter(factory,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 1; i < 112; i++){
            String url = "http://ypk.familydoctor.com.cn/factorys_0_0_0_"+i+".html";
            try {
                rootDoc = Jsoup.connect(url).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements all = rootDoc.select(".textList");
            Elements fac = all.select("a");
            for (Element each:fac){
                try {
                    fw.write(each.text()+" @f NeOrg\n");
                    count++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            fw.write("总共"+count+"个\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("王城");
    }
}
