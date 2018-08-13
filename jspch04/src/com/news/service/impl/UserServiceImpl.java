package com.news.service.impl;

import com.news.dao.UserDao;
import com.news.dao.impl.UserDaoImpl;
import com.news.entity.Users;
import com.news.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao=new UserDaoImpl();
	@Override
	public Users getUsers(String username, String password) {
		return userDao.login(username, password) ;
	}
  
}
