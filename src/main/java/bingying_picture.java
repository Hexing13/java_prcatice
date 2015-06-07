import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hexing on 15-6-2.
 */
public class bingying_picture {
    public static void WriteImgToFile(HttpEntity httpEntity, String address){
        File imgFile = new File("/home/hexing/picture/biying/"+ address);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(imgFile);
            if(httpEntity != null){
                InputStream inputStream = httpEntity.getContent();
                byte[] b = new byte[1000];
                int i;
                while ((i = inputStream.read(b))!= -1){
                    fileOutputStream.write(b,0,i);
                }
            }
        }catch (IOException e){
            System.out.println("sss");
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println("ccc");
                e.printStackTrace();

        }
    }

}

    public static void main(String[] args) throws IOException {
        System.out.println("获取必应首页的图片地址...");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://cn.bing.com/");
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            Pattern p = Pattern.compile("http://.*?.jpg");
            Matcher m = p.matcher(EntityUtils.toString(httpResponse.getEntity()));
            String address = null;
            if(m.find()){
                address = m.group();
            }else {
                System.out.println("抱歉，没有找到！");
                System.exit(1);
            }
            System.out.println("图片的地址："+ address);
            System.out.println("正在下载...");
            HttpGet getimg = new HttpGet(address);
            CloseableHttpResponse responseimg = httpClient.execute(getimg);
            HttpEntity httpEntity = responseimg.getEntity();
            WriteImgToFile(httpEntity,dateFormat.format(new Date())+".jpg");
            System.out.println("OK, 下载完成!!");
        } catch (IOException e) {
            System.out.println("aaa");
            e.printStackTrace();
        }
    }
}
