package com.hexing.jdbc;

import java.sql.*;

/**
 * Created by hexing on 15-11-14.
 */
public class test {

    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/mybatis";
        String user = "root";
        String password = "hx106107";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driver);
            try {
                connection = DriverManager.getConnection(url,user,password);
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select id,name from test");
                while (resultSet.next()){
                    System.out.println("id:"+resultSet.getString("id"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(resultSet!=null){
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if(statement!=null){
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
