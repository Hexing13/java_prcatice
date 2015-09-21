package com.hexing.review_java;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by hexing on 15-9-18.
 */
public class Lists {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
//        System.out.println(list.listIterator(0).next());
//        System.out.println(list.listIterator(1).next());
//        System.out.println(list.subList(1,3));
//        ListIterator it = list.listIterator();
//        it.add("sss");
//        System.out.println(list);
//        while (it.hasNext()){
//            System.out.println(it.nextIndex()+": "+it.next());
//        }
        ListIterator it1 = list.listIterator();
        System.out.println(it1.next());
        it1.set("ooo");
        System.out.println(list);

    }
}
