package com.kaushik.vote.impl.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kaushik.vote.VoteCandidate;
import com.kaushik.vote.model.Candidate;
import com.kaushik.vote.model.Cast;
import com.kaushik.vote.model.Users;
import com.kaushik.vote.util.ConnectionUtil;

public class CastDAO implements VoteCandidate {
     
	
	//a.) Updating the user vote to respective candidate
    //b.) Getting vote count of individual candidate
	//c.) Getting vote count of all candidates   


	//a.) Updating the user vote to respective candidate

      public void addVote(Cast cast){
    	    
    	  Connection conn = ConnectionUtil.getConnection();
    	  
    	  String newVote = "Insert into candidate_votes (user_id, candidate_id, cast_date) values (?,?,?)";
    	  try {
			PreparedStatement prepareVote = conn.prepareStatement(newVote);
			prepareVote.setInt(1, cast.getUserID());
            prepareVote.setInt(2, cast.getCandidateID());
            prepareVote.setString(3, cast.getVotedDate());
			
		    int resultVote = prepareVote.executeUpdate();
		    
		    System.out.println(resultVote+ " Added");
		    
		    String updateVote = "Update users set entry = entry+1 where user_id ="+cast.getUserID();
		    PreparedStatement prepareUpdateVote = conn.prepareStatement(updateVote);
		    int resultUpdateVote = prepareUpdateVote.executeUpdate();
		    
		    System.out.println(resultUpdateVote+" entry updated");
    	  }  //close of try
    	  catch (SQLException e) {
			e.printStackTrace();
      		} // close of catch
    	  
    	  finally{
    		  try{
    			    if(conn != null)
    			    	 conn.close();
    		  }
    		  catch(SQLException se){
    		  }
    	  } // close of finally block
    	  
      }
    
    //b.) Getting vote count of individual candidate
      
      public int getVoteCountByID(Cast cast){
    	   
    	  Connection conn = ConnectionUtil.getConnection();
    	  
    	  String voteCount = "select count(*) from candidate_votes where candidate_id = ?";
    	  
    	   int totalCount = 0;
		try {
			PreparedStatement prepareVoteCount = conn.prepareStatement(voteCount);
			prepareVoteCount.setInt(1, cast.getCandidateID());
			ResultSet resultVoteCount = prepareVoteCount.executeQuery();
          
			while(resultVoteCount.next())
			      totalCount = Integer.parseInt(String.valueOf(resultVoteCount.getInt(1)));
		 } 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		
		 finally{
   		  try{
   			    if(conn != null)
   			    	 conn.close();
   		  }
   		  catch(SQLException se){
   		  }
   	  } // close of finally block
		
         return totalCount;
      }
      
      
   //c.) Getting vote count of all candidates   
      public ArrayList<String> getVoteCountOfAll(Cast cast){
    	 
    	 Connection conn = ConnectionUtil.getConnection();
    	 ArrayList<String> listOfAll = new ArrayList<String>();
    	
    
      try{	 
    	 for(int i=0; i<=8; i=i+2){
    		 String voteCount = "select count(*) from candidate_votes where candidate_id = ?";
       	  
      	   int totalCount =0;
      	   int id = cast.getCandidateID()+i;
      	   
  		   try {
  			 PreparedStatement prepareVoteCount = conn.prepareStatement(voteCount);
  			 prepareVoteCount.setInt(1, id);
  			 ResultSet resultVoteCount = prepareVoteCount.executeQuery();
            
  			 while(resultVoteCount.next())
  			      totalCount = Integer.parseInt(String.valueOf(resultVoteCount.getInt(1)));
  			 
  			   listOfAll.add(String.valueOf(id)+" "+String.valueOf(totalCount));
  		   } 
  		   catch (SQLException e) {
  			  // TODO Auto-generated catch block
  			  e.printStackTrace();
  		     }
    	  }
       }
       catch(Exception ae){
    	   System.err.println(ae.getMessage());
       }
  		finally{
     		   try{
     			    if(conn != null)
     			    	 conn.close();
     		   }
     		   catch(SQLException se){
     		     }
    		 }
    	 
		 return listOfAll;
      }

	public void newCandidate(Candidate addNew) {}

	public ArrayList<String> showCandidates() {
		return null;
	}

	public ArrayList<String> findById(Candidate find) {
		return null;
	}

	public void register(Users user) {}

	public boolean login(Users user) {
		return false;
	}
	
}
