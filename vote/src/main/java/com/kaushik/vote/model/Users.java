package com.kaushik.vote.model;

public class Users {

    private String adhaarName;
    private String adhaarNumber;
    private String dob;
    private String username;
    private String password;
    private String mobileNumber;
    private String gender;
    private int entry;
    
	public String getAdhaarName() {
		return adhaarName;
	}
	public void setAdhaarName(String adhaarName) {
		this.adhaarName = adhaarName;
	}
	public String getAdhaarNumber() {
		return adhaarNumber;
	}
	public void setAdhaarNumber(String adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getEntry() {
		return entry;
	}
	public void setEntry(int entry) {
		this.entry = entry;
	}
	
	@Override
	public String toString() {
		return "Users [adhaarName=" + adhaarName + ", adhaarNumber=" + adhaarNumber + ", dob=" + dob + ", username="
				+ username + ", password=" + password + ", mobileNumber=" + mobileNumber + ", gender=" + gender
				+ ", entry=" + entry + "]";
	}
    
    
	
}
