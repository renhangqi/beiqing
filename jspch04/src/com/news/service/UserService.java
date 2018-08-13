package com.news.service;

import com.news.entity.Users;

public interface UserService {
  public Users getUsers(String username,String password);
}
