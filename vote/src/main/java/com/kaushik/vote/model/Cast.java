package com.kaushik.vote.model;

import java.time.LocalDate;

public class Cast {

	private int userID;
	private int candidateID;
	private String votedDate;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCandidateID() {
		return candidateID;
	}
	public void setCandidateID(int candidateID) {
		this.candidateID = candidateID;
	}
	public String getVotedDate() {
		return votedDate;
	}
	public void setVotedDate(String localDate) {
		this.votedDate = localDate;
	}
	
	@Override
	public String toString() {
		return "Cast [userID=" + userID + ", candidateID=" + candidateID + ", votedDate=" + votedDate + "]";
	}
	
	
	
}
