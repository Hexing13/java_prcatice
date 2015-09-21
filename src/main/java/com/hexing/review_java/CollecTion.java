package com.hexing.review_java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by hexing on 15-9-16.
 */
public class CollecTion {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("s1");
        collection.add(2);
        collection.add("he");
        System.out.println(collection.size());
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Object element = iterator.next();
            System.out.println(element);
            iterator.remove();
        }
        System.out.println(collection.isEmpty());
    }
}
