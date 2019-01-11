package com.kaushik.vote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.kaushik.vote.model.Users;
import com.kaushik.vote.util.ConnectionUtil;

public class RegisterValidate {
	 
 public boolean userValidate(Users user){
        
   	 int invalid = 0;
   	 boolean value = false;
   	    
  //a.) Adhaar Card Digits check 	 
   	if(user.getAdhaarNumber().length()!=12){
   		System.out.println("Enter the valid 12 digit adhaar card number");
           invalid++;
   	}
   	
  //b.) dob 	
   	String year = user.getDob().substring(6,10);
   	if(Integer.parseInt(year)>2000){
   		   System.out.println("Only above 18 age people are eligible");
   		   invalid++;
   	}
	
  //c.)Checking Username and password already existing or not
   	
   	String usernameCheckCopy="", passwordCheckCopy="";
   	Connection conn = ConnectionUtil.getConnection();
   	
       String usernameQuery = "SELECT COUNT(*) FROM users WHERE username = ?"; 
       PreparedStatement preparestatement1;
		try {
			preparestatement1 = conn.prepareStatement(usernameQuery);
			preparestatement1.setString(1, user.getUsername());
		    ResultSet result1 = preparestatement1.executeQuery();
		    
		    while(result1.next())
	         {
	        	 usernameCheckCopy = result1.getString(1);
	         }
		    
	        int val1 = Integer.parseInt(usernameCheckCopy);

	        if(val1 >= 1) {
	        	System.out.println("Username already Exists, please change and try");
	        	invalid++;
	        }
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
     //  System.out.println(usernameCheckCopy);
       
       String passwordQuery = "SELECT COUNT(*) FROM users WHERE u_password = ?"; 
       PreparedStatement preparestatement2;
		try {
			preparestatement2 = conn.prepareStatement(passwordQuery);
			preparestatement2.setString(1, user.getPassword());
		    ResultSet result2 = preparestatement2.executeQuery();
		        
		      while(result2.next()){
		       	      passwordCheckCopy = result2.getString(1);
		        }

			int val2 = Integer.parseInt(passwordCheckCopy);

			if (val2 >= 1) {
				System.out.println("Password already exists, please change and try");
				invalid++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 finally{
			 try
	          {
	              if(conn!=null)
	                  conn.close();
	          }
	          catch(SQLException se){}
		  }  // finally close
            
   	
     // d.) mobile number
   	   if(user.getMobileNumber().length() != 10)
   	   {
   		 System.out.println("Please enter 10 digit number");
   		 invalid++;
   	   }
   	
      // e.) password check 
     	if(!Pattern.matches("[a-zA-Z]{8,}+[0-9]{1,}", user.getPassword()))
   	   {
   		  System.out.println("Please enter valid password which has 8 characters with atleast 1 number ");
   		  invalid++;
   	   }
         
        if(invalid == 0)
       	     value = true;
        else
       	     value = false;
        
         
       return value;
        
	}
}
