package com.news.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.news.dao.UserDao;
import com.news.dao.impl.UserDaoImpl;
import com.news.entity.Users;

public class UserTest {

	@Test
	public void test() {
		    UserDao userDao=new UserDaoImpl();
		    Users users=userDao.login("admin", "123");
		    System.out.println(users.getTel());
	}
	

	
}
