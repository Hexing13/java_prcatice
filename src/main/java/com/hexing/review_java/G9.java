package com.hexing.review_java;

import java.util.Arrays;

/**
 * Created by hexing on 16-3-29.
 */
public class G9 {
    public static void find(int[] a)
    {
        Arrays.sort(a);
        for(int i = a.length-1;i > 0;i++){
            int left = 0,right = i-1;
            while (left<right){
                if(a[left]+a[right]==a[i]){
                    System.out.println("找到"+a[left]+"+"+a[right]+"="+a[i]);
                    return;
                }else if(a[left]+a[right]<a[i]){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        find(a);
    }
}
