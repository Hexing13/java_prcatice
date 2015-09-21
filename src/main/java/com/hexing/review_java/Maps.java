package com.hexing.review_java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by hexing on 15-9-18.
 */
public class Maps {
    public static void main(String[] args) {
        Map map1 = new HashMap();
        Map map2 = new LinkedHashMap();
        for (int i = 0; i < 10; i++){
            double s = Math.random()*100;
            map1.put("第"+i+"个",s);
            map2.put("第"+i+"个",s);
        }
        System.out.println(map1);
        System.out.println(map2);
        Map sortedmap = new TreeMap(map1);
        System.out.println(sortedmap);
        System.out.println(new TreeMap(map2));
//        Map map2 = new HashMap();
//        map1.put("1","aaa1");
//        map1.put("2","bbb2");
//        map2.put("10","aaa10");
//        map2.put("11","bbb11");
//        System.out.println(map1.get("1"));
//        System.out.println(map1.remove("1"));
//        System.out.println(map1.get("1"));
//        map1.putAll(map2);
//        map2.clear();
//        System.out.println(map1.isEmpty());
//        System.out.println(map2.isEmpty());
//        System.out.println(map1.size());
//        System.out.println(map1.keySet());
//        System.out.println(map1.values());
//        System.out.println(map1.entrySet());
//        System.out.println(map1.containsKey("11"));
//        System.out.println(map1.containsValue("bbb11"));
    }
}
