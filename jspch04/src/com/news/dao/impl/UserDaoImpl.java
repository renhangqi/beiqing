package com.news.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import com.news.dao.UserDao;
import com.news.entity.NewType;
import com.news.entity.Users;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public Users login(String username, String password) {
		String sql="select * from users where username=? and password=?";
		Users u=null;
		try {
			ResultSet rs=this.executeQuery(sql, new Object[] {username,password});
			if(rs.next()) {
				//创建实体
				u=new Users();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setTel(rs.getString(4));
				u.setEmail(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return u;
	}
	
	public static void main(String[] args) {
	    UserDao userDao=new UserDaoImpl();
	    Users users=userDao.login("admin", "123");
	    System.out.println(users.getTel());
	}
}
