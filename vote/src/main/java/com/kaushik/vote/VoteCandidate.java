package com.kaushik.vote;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kaushik.vote.model.Candidate;
import com.kaushik.vote.model.Cast;
import com.kaushik.vote.model.Users;

public interface VoteCandidate {
      
	// CandidateDAO
	   public void newCandidate(Candidate addNew);
	   public ArrayList<String> showCandidates();
	   public ArrayList<String> findById(Candidate find);
	   
	//UsersDAO
	   public void register(Users user);
	   public boolean login(Users user);
	   
	//CastDAO
	   public void addVote(Cast cast) throws SQLException;
	   public int getVoteCountByID(Cast cast); 
	   public ArrayList<String> getVoteCountOfAll(Cast cast);

}