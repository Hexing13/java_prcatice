package com.hexing.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by hexing on 15-8-18.
 */
public class Proxy {
    public static Object newProxyInstance(Class inter) {
        String src = "package com.hexing.proxy;\n" +
                "\n" +
                "public class TankTimeProxy implements "+inter.getName()+"{\n" +
                "    MoveAble t;\n" +
                "    public TankTimeProxy(MoveAble t){\n" +
                "        super();\n" +
                "        this.t = t;\n" +
                "    }\n" +
                "    @Override\n" +
                "    public void move() {\n" +
                "        long start = System.currentTimeMillis();\n" +
                "        t.move();\n" +
                "        long end = System.currentTimeMillis();\n" +
                "        System.out.println(\"运行时间：\"+(end-start));\n" +
                "    }\n" +
                "}\n";

        //源码
        String filedName = System.getProperty("user.dir") + "/src/main/java/com/hexing/proxy/TankTimeProxy.java";
        File file = new File(filedName);
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(src);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileManager.getJavaFileObjects(filedName);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, units);
        task.call();
        try {
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //load到内存，并实例化
        try {
            URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
            URLClassLoader loader = new URLClassLoader(urls);
            try {
                Class c = loader.loadClass("com.hexing.proxy.TankTimeProxy");
                try {
                    Constructor constructor = c.getConstructor(MoveAble.class);
                    try {
                        MoveAble m = (MoveAble) constructor.newInstance(new Tank());
                        m.move();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
