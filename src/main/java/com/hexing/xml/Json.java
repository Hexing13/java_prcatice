package com.hexing.xml;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hexing on 15-11-13.
 */
public class Json {
    //构造json对象
    JSONObject jo = null;
    String josnText = "{\"id2\":\"hhhh\",\"id1\":\"hexing\",\"id3\":\"xxxx\"}";
    public Json(){
        try {
            jo = new JSONObject(josnText);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        try {
            System.out.println(jo.getString("id1"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Json().print();
    }
}
