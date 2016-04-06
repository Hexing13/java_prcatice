package com.hexing.jdbc;

import java.sql.*;
import java.util.Random;

/**
 * Created by hexing on 15-11-14.
 */
public class test {
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/mybatis";
        String user = "root";
        String password = "hx106107";
        Connection conn = null;
        try {
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(url,user,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 开始时间
        Long begin = new Date(System.currentTimeMillis()).getTime();
        // sql前缀
        String prefix = "INSERT INTO bigdata2 VALUES ";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement("");
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 1000; i++) {
                // 第次提交步长
                for (int j = 1; j <= 1000; j++) {
                    // 构建sql后缀
                    suffix.append("("+null+",\""+getRandomString(7)+"\","+Math.random()+"),");
                }
                // 构建完整sql
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
//                System.out.println(sql);
                // 添加执行sql
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date(System.currentTimeMillis()).getTime();
        // 耗时
        System.out.println("cast : " + (end - begin) / 1000 + " s");
    }
}
