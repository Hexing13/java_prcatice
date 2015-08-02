import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by hexing on 15-7-30.
 */
class Count
{
    private int count;
    public int add(){
        synchronized (this){
            count = count+1;
            return count;
        }
    }
}

class th extends Thread{
    String name;
    private Count c;
    int a[] = new int[10];
    public th(String name,Count c){
        this.name = name;
        this.c = c;
    }
    public void run(){
        Document rootDoc = null;
        for(int i = 0; i < 10;i++){
            try {
                a[i] = c.add();
                rootDoc = Jsoup.connect("http://yao.xywy.com/goods/"+a[i]+".htm").userAgent("Mozilla/5.0 (X11; Linux i686 (x86_64)) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.125 Safari/537.36").timeout(10000).get();
                String title = null;
                title = rootDoc.select(".f20").text();
                System.out.println(title);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Medc {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        Count c = new Count();
        for(int i = 1; i <= 10; i++){
            new th(String.valueOf(i),c).start();
        }
        try {
            t.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wancheng");
    }

}
