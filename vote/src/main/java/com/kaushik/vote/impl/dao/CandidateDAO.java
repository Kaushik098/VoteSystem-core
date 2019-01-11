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

public class CandidateDAO implements VoteCandidate{

	//a.) Lists All Candidates
	//b.) Add new Candidate
	//c.) Getting candidate name using canidate id
	
	
	//a.) Lists All Candidates
	    public ArrayList<String> showCandidates(){
	    	   
	    	   Connection conn = ConnectionUtil.getConnection();
	    	   Candidate value = new Candidate();
	    	   ArrayList<String> al = new ArrayList<String>();
	    	  
	    	  try{ 
	    	   String candidateList = "Select * from candidate"; 
			   PreparedStatement prepareCandidateList = conn.prepareStatement(candidateList);
			   ResultSet result = prepareCandidateList.executeQuery();
				
			   String id="";
			   String name="";
				   while(result.next())
				   {  
					   id = String.valueOf(result.getInt(1));					    
                       name = String.valueOf(result.getString(2));
                       
                       al.add(id+" "+name);
				   }
	    	  }
	    	  catch(SQLException se)
	    	  {
	    		  System.err.println(se.getMessage());
	    	  }
	    	  
	    	  finally{
    	          try
    	          {
    	              if(conn!=null)
    	                  conn.close();
    	          }
    	          catch(SQLException se){}
    	      }   
			
	    	  return al;  
			 
	    } // a.) end

	
	    
	    
	    
	//b.) Adding new Candidate
	    
		public void newCandidate(Candidate addNew) {
			   Connection conn = ConnectionUtil.getConnection();
			   
			   String candidate = "Insert into candidate (candidate_id, candidate_name) VALUES (?,?)";
			   try {
				PreparedStatement prepareCandidate = conn.prepareStatement(candidate);
				prepareCandidate.setInt(1, addNew.getCandidateId());
				prepareCandidate.setString(2, addNew.getCandidateName());
				int resultCandidate = prepareCandidate.executeUpdate();
				
				System.out.println(resultCandidate+" row Added");
			  } catch (SQLException e) {
				e.printStackTrace();
			}
			   
			   finally{
	    	          try
	    	          {
	    	              if(conn!=null)
	    	                  conn.close();
	    	          }
	    	          catch(SQLException se){}
	    	      }  
			   
		}  // b.) end
	 
   
		
		
		
	//c.) Show candidate name using candidate id
		
	public ArrayList<String> findById(Candidate find){
		
		Connection conn = ConnectionUtil.getConnection();
		
		Candidate candidateSelectByID  = new Candidate();
		
		ArrayList<String> candidate = new ArrayList<String>();

    try{		
		String selectById = "Select candidate_name from candidate where candidate_id = ?";
		PreparedStatement prepareSelectById = conn.prepareStatement(selectById);
		prepareSelectById.setInt(1, find.getCandidateId());
		ResultSet resultSelectById = prepareSelectById.executeQuery();
		
		
		while(resultSelectById.next()){
		     candidate.add(resultSelectById.getString(1));	  
		}
    }
    catch(SQLException se)
	  {
		  System.err.println(se.getMessage());
	  }
	  
	  finally{
        try
        {
            if(conn!=null)
                conn.close();
        }
        catch(SQLException se){}
    }   
	
		return candidate;
 }  //c.) end





	public void register(Users user) {}
	
	public boolean login(Users user) {
		return false;
	}
	
	public void addVote(Cast cast) throws SQLException {}

	public int getVoteCountByID(Cast cast) {
		return 0;
	}

	public ArrayList<String> getVoteCountOfAll(Cast cast) {
		return null;
	}	
}
	
