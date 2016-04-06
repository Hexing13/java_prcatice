package com.hexing.review_java;

import java.util.Arrays;

/**
 * Created by hexing on 16-3-29.
 */
public class Zidianxu {

    public static void main(String[] args) {
        int count = 1;
        int i,j;
        String str = "14325";
        char[] st = str.toCharArray();
        Arrays.sort(st);
        System.out.println(st);
        while ((i = lowPos(st))!=-1){
            j = MinMax(i,st);
            swap(i,j,st);
            rever(i,st);
            count++;
            System.out.println(st);
        }
        System.out.println("共"+count+"个");
    }
    //从右至左找出第一个左边小于右边的数字
    public static int lowPos(char[] st){
        for(int i = st.length-2;i>=0;i--){
            if(st[i] < st[i+1]){
                return i;
            }
        }
        return -1;
    }

    //找出lowPos右边比他大的最小的数字
    public static int MinMax(int lowpos,char[] st){
        int min = lowpos;
        for(int i = lowpos+1;i<st.length;i++){
            if(st[i] > st[lowpos]){
                min = i;
            }
        }
        return min;
    }

    //交换
    public static void swap(int i,int j,char[] st){
        char temp = st[i];
        st[i] = st[j];
        st[j] = temp;
    }

    //反转
    public static void rever(int lowPos,char[] st){
        int j = st.length-1;
        int len = j-lowPos;
        for(int i = lowPos+1;i<=lowPos+len/2;i++)
            swap(i,j--,st);
    }
}