package com.kaushik.vote.test;

import java.sql.SQLException;
import java.util.*;


import com.kaushik.vote.impl.dao.CandidateDAO;
import com.kaushik.vote.model.Candidate;

public class CandidateTest {

	public static void main(String args[]) throws SQLException{
		 
	//a.) to display the candidates
		
	 CandidateDAO candidate = new CandidateDAO();
	 ArrayList<String> allcandidates = candidate.showCandidates();   
		 
	 System.out.print(allcandidates);    
		
	
	//b.) to add a new candidate
		 
	/*	 Candidate add = new Candidate();
		 
		 add.setCandidateId(1808);
		 add.setCandidateName("Sachin Tendulkar");
		 
		 CandidateDAO addCandidate = new CandidateDAO();
		 addCandidate.newCandidate(add);    */
	 
		
	//c.) get candidate name by id
		
		
	/* Candidate find = new Candidate();
	 
	 find.setCandidateId(1800);
		
     CandidateDAO candidateSelectByID = new  CandidateDAO();
     ArrayList<String> candidateName = candidateSelectByID.findById(find);
     
     System.out.println(candidateName);   */
     
	}
}
