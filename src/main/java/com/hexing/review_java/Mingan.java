package com.hexing.review_java;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by hexing on 16-3-28.
 */
public class Mingan {
    public boolean check(String str){
        char[] st = str.toCharArray();
        char temp;
        Stack<Character> stack = new Stack();
        for(int i = 0; i < st.length;i++){
            if(st[i]=='[' || st[i]=='(' || st[i]=='{'){
                stack.add(st[i]);
            }else {
                if(stack.isEmpty())
                    return false;
                else {
                    temp = stack.peek();
                    if(temp=='[' && st[i]==']' || temp=='(' && st[i]==')' || temp=='{' && st[i]=='}'){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String reader = scanner.nextLine();
        if(new Mingan().check(reader)){
            System.out.println("yes--匹配");
        }else {
            System.out.println("no--不匹配");
        }
    }
}
