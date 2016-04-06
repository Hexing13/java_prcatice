package com.hexing.review_java;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by hexing on 15-11-20.
 */
public class Float {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("a");
        v.add("b");
        Enumeration e = v.elements();
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }
}
