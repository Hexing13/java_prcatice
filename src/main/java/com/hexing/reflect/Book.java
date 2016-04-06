package com.hexing.reflect;

/**
 * Created by hexing on 15-8-17.
 */
public class Book {
    private int id;
    private String name;
    private String type;
    public long aLong;

    public Book(){}
    public Book(String name){ this.name = name;}

    public long getaLong() {
        return aLong;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String test(String aa,int bb){
        return "调用了多参数:"+aa+"  "+bb;
    }
}
