package com.hexing.review_java;

/**
 * Created by hexing on 16-3-29.
 */
public class Quanpailie {

    public void swap(String[] str,int i,int st){
        String temp = new String();
        temp = str[i];
        str[i] = str[st];
        str[st] = temp;
    }

    public void change(String[] str,int st,int length){
        if(st == length-1){
            for (st = 0; st < length;st++){
                System.out.print(str[st] + " ");
            }
            System.out.println();
        }else {
            for(int i = st;i < length;i++){
                swap(str,i,st);
                change(str,st+1,length);
                swap(str,st,i);
            }
        }
    }

    public static void main(String[] args) {
        String[] str = {"1","2","3"};
        new Quanpailie().change(str, 0, str.length);
    }
}
