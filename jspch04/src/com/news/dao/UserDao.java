package com.news.dao;

import com.news.entity.Users;

public interface UserDao {
    //���뷽��
	public Users login(String username,String password);
	
}
