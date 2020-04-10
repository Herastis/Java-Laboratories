package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.company.Main.*;

public class Database {
    static Connection conn=null;


    public static Connection getConnection() {
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
      return conn;
    }

}