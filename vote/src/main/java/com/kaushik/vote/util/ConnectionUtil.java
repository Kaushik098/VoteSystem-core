package com.kaushik.vote.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	 private static final String  hostname = "jdbc:mysql://13.233.226.80:3306/kaushik_db";
	   private static final String username = "kaushik";
	   private static final String password = "kaushik";

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		  Connection conn = null;
		  
		  try{
			  conn = DriverManager.getConnection(hostname, username, password);
			  System.out.println("Database Connected");
		  }
		  catch(Exception ae){
			  System.err.println(ae.getMessage());
		  }
		return conn;
	}
}
