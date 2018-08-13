package com.news.dao;

import java.util.List;

import com.news.entity.NewInfo;

public interface NewInfoDao {
  //添加新闻
  public int addNew(NewInfo info);
  
  //查询所有新闻
  public List<NewInfo> getAllNew();
  
  //查询单条
  public NewInfo getNew(int nid);
  
  //通过新闻类别查询对应的新闻
  public List<NewInfo> getNewByType(int tid);
}
