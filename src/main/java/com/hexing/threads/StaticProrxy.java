package com.hexing.threads;

/**
 * Created by hexing on 15-8-4.
 */
interface Marry
{
    void marry();
}

class You implements Marry
{

    @Override
    public void marry() {
        System.out.println("你和猪结婚了！！！");
    }
}

class Company implements Marry
{
    private Marry you;

    public Company(){}
    public Company(Marry you){
        this.you = you;
    }
    public void before(){
        System.out.println("布置猪窝！!!");
    }
    public void after(){
        System.out.println("闹洞房!!!");
    }
    @Override
    public void marry() {
        before();
        you.marry();
        after();
    }
}
public class StaticProrxy {
    public static void main(String[] args) {
        You you = new You();
        Company company = new Company(you);
        company.marry();
    }
}
