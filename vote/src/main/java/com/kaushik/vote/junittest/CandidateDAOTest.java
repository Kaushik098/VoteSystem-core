package com.kaushik.vote.junittest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kaushik.vote.impl.dao.CandidateDAO;
import com.kaushik.vote.model.Candidate;

public class CandidateDAOTest {

	static int beforeclass = 1;
	static int afterclass = 1;
	static int before = 1;
	static int after = 1;
	
	static CandidateDAO candidateDAO;
	static Candidate  candidate;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	        candidate = new Candidate();
	        candidateDAO = new CandidateDAO();
	        System.out.println("Before Class: "+ beforeclass++ );
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		 System.out.println("After Class: "+ afterclass++ );
	}

	@Before
	public void setUp() throws Exception {
		  System.out.println("Before: "+ before++ );
	}

	@After
	public void tearDown() throws Exception {
		 System.out.println("After: "+ after++ );
	}

	@Test
	public void testShowCandidates() throws SQLException { 
		  assertEquals(5, candidateDAO.showCandidates().size());
		  assertNotEquals(4, candidateDAO.showCandidates().size());
	}

	@Test
	public void testFindById() throws SQLException {
		  
		//  System.out.println("find by ID");
		  candidate.setCandidateId(1800);
		  ArrayList<String> al = new ArrayList<String>();
		  al.add("Virat Kholi");
		  
		  assertEquals(al,candidateDAO.findById(candidate));
	}

}
