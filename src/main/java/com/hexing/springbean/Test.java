package com.hexing.springbean;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by hexing on 15-8-18.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
       // p.load(Test.class.getClassLoader().getResourceAsStream("/home/hexing/JAVA/java_Practice/src/main/java/com/hexing/springbean/spring.properties"));
        String vTypeName = p.getProperty("Vtype");
        System.out.println(vTypeName);

    }
}
