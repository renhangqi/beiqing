package com.news.dao;

import java.util.List;

import com.news.entity.NewInfo;

public interface NewInfoDao {
  //�������
  public int addNew(NewInfo info);
  
  //��ѯ��������
  public List<NewInfo> getAllNew();
  
  //��ѯ����
  public NewInfo getNew(int nid);
  
  //ͨ����������ѯ��Ӧ������
  public List<NewInfo> getNewByType(int tid);
}
