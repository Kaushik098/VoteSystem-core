package com.kaushik.vote.junittest;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kaushik.vote.impl.dao.UsersDAO;
import com.kaushik.vote.model.Users;

public class UsersDAOTest {

	static int beforeclass = 1;
	static int afterclass = 1;
	static int before = 1;
	static int after = 1;
	
	static UsersDAO userDAO;
	static Users  user;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	         user = new Users();
	         userDAO = new UsersDAO();
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
	public void test() {
		user.setUsername("bhuvana");
		user.setPassword("bhuvi001");
		user.setAdhaarNumber("202020101010");
		assertTrue(userDAO.login(user));
	}
	
}
