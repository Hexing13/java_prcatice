package com.hexing.review_java;

import java.util.Scanner;

/**
 * Created by hexing on 16-3-30.
 */
public class Index {
    public static void main(String[] args) {
        String str = "aaaabbbcccdddaaacccdddaaa";
        int index=0,sum=0;
        System.out.println("请输入要查找的单词：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(s!=null){
            if((index=str.indexOf(s))==-1){
                System.out.println("没有");
            }else {
                while (index!=-1){
                    System.out.println("位置:");
                    System.out.println(index);
                    index = str.indexOf(s,index+1);
                    sum++;
                }
            }
        }
        System.out.println("总共:"+sum);
    }
}
//public class Index
//{
//    public static void main(String[] args) throws  IOException {
//        String str = "aaabbbcccdddaaacccdddaaa";
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("请输入要查找的单词");
//
//        String findStr = br.readLine();
//
//        int strIndex = 0;
//        int sum = 0;
//
//        if (findStr != null && findStr.length() != 0)
//        {
//            strIndex = str.indexOf(findStr);
//
//            if (strIndex == -1)
//            {
//                System.out.println("没找到");
//            }
//            else
//            {
//                System.out.print("位置：");
//
//                while (strIndex != -1)
//                {
//                    System.out.print(strIndex + " ");
//
//                    //从之前找的位置的后面接着找
//                    strIndex = str.indexOf(findStr, strIndex + 1);
//
//                    sum++;
//                }
//
//                System.out.println("\r\n总共：" + sum + "个");
//            }
//        }
//    }
//}