package com.hexing.review_java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hexing on 15-9-21.
 */
public class Sets {
    public static void main(String[] args) {
        Set set1 = new HashSet();
        if(set1.add("a")){
            System.out.println("1 添加成功");
        }
        if(set1.add("a")){
            System.out.println("2 添加成功");
        }
        set1.add("222");
        set1.add("333");
//        System.out.println(set1.size());
//        System.out.println(set1);
        set1.remove("000");
        System.out.println(set1.contains("000"));
        System.out.println(set1.contains("111"));
    }
}
