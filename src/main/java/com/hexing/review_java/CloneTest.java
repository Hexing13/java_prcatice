package com.hexing.review_java;

import java.io.Serializable;

/**
 * Created by hexing on 15-10-29.
 */
class User implements Cloneable,Serializable
{
    int id;
    int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public User(int id,int age){
        this.id = id;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (id != user.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + age;
        return result;
    }
}

class Administrator implements Cloneable,Serializable
{

    private User user;
    private boolean editable;

    public Administrator(User user,boolean editable){
        this.user = user;
        this.editable = editable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Administrator that = (Administrator) o;

        if (editable != that.editable) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (editable ? 1 : 0);
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        return  super.clone();
    }
}

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Administrator a1 = new Administrator(new User(1,12),true);
        Administrator a3 = BeanUtil.cloneTo(a1);

        System.out.println(a1==a3);//false
        System.out.println(a1.equals(a3));//true
        System.out.println(a1.getUser()==a3.getUser());//false
        System.out.println(a1.getUser().equals(a3.getUser()));//true
    }
}
