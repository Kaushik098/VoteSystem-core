package com.kaushik.vote.junittest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kaushik.vote.impl.dao.CastDAO;
import com.kaushik.vote.model.Candidate;
import com.kaushik.vote.model.Cast;

public class CastDAOTest {

	static int beforeclass = 1;
	static int afterclass = 1;
	static int before = 1;
	static int after = 1;
	
	static CastDAO castDAO;
	static Cast  cast;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	        cast = new Cast();
	        castDAO = new CastDAO();
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
	public void testVoteCount() {
        cast.setCandidateID(1800);
		assertEquals(1, castDAO.getVoteCountByID(cast));
        assertNotEquals(0, castDAO.getVoteCountByID(cast));		 
	}

}
