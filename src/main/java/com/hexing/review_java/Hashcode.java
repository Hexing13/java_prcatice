package com.hexing.review_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hexing on 15-11-27.
 */
public class Hashcode {
   static String a = new String("aaa");
    ArrayList b = new ArrayList();
    LinkedList l = new LinkedList();
    ConcurrentHashMap c = new ConcurrentHashMap();
    public static void main(String[] args) {
        a.hashCode();
    }
}
