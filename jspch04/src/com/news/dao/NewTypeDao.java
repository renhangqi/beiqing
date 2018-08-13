package com.news.dao;

import java.util.List;

import com.news.entity.NewType;

//dao接口
public interface NewTypeDao {
   //添加主题 的方法
	public int addType(NewType nt);
	
	//查询所有主题
	public List<NewType> getAllType();
	
	//删除主题  一功能一方法
	public  int delType(int tid);
	
	//通过主键 查询单条
	public NewType getType(int tid);
	
	//修改功能
	public int updateType(NewType nt);
	
	//实现分页显示   当前页的数据
	public List<NewType> getTypeByPage(int pageSize,int page);
	//查询总页数   总页数
	public int getTotalPage(int pageSize);
	
	
}
