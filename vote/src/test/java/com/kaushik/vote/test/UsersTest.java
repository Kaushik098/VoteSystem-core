package com.kaushik.vote.test;

import com.kaushik.vote.RegisterValidate;
import com.kaushik.vote.impl.dao.UsersDAO;
import com.kaushik.vote.model.Users;

public class UsersTest {

	 public static void main(String args[]){
		  	 
		 Users users = new Users();
		
// Registration
		 
  /*	 users.setAdhaarName("Karthik");
		 users.setAdhaarNumber("202020101011");
		 users.setDob("07/04/2000");
		 users.setUsername("karthick");
		 users.setPassword("karthick008");
		 users.setMobileNumber("9080908090");
		 users.setGender("male");
		 users.setEntry(0);
		 
		 RegisterValidate userValidate = new RegisterValidate();
		 boolean value = userValidate.userValidate(users);
				 
		 if(value){
		     UsersDAO registerUser = new UsersDAO();
		   //  System.out.println("Successfully registered");
		     registerUser.register(users);
		 }
		 else{
			 System.out.println("Please change the incorrect fields and try with proper credentials");
		 }
		     
	    */	 
		 
//Login
		 
		 users.setUsername("bhuvana");
		 users.setPassword("bhuvi001");
		 users.setAdhaarNumber("202020101010");
		 
		 UsersDAO loginUser = new UsersDAO();
		 boolean login = loginUser.login(users);   
		 
		 System.out.println(login);
	 }
}
