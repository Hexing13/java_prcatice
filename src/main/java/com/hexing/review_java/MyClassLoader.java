package com.hexing.review_java;

import java.io.*;

/**
 * Created by hexing on 16-3-4.
 */
public class MyClassLoader extends ClassLoader {
    private String rootDir;

    public MyClassLoader(String rootDir){
        this.rootDir = rootDir;
    }

    private String classNameToPath(String className){
        return rootDir+ File.separatorChar+className.replace('.',File.separatorChar)+".class";
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        InputStream ins = null;
        try {
            ins = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream by = new ByteArrayOutputStream();
        int size = 4096;
        byte[] buffer = new byte[size];
        int byteRead = 0;
        try {
            while ((byteRead = ins.read(buffer))!= -1){
                by.write(buffer,0,byteRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return by.toByteArray();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classDate = getClassData(name);
        return defineClass(name,classDate,0,classDate.length);
    }

    public static void main(String[] args) {

    }
}
