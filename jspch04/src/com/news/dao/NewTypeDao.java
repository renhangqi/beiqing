package com.news.dao;

import java.util.List;

import com.news.entity.NewType;

//dao�ӿ�
public interface NewTypeDao {
   //������� �ķ���
	public int addType(NewType nt);
	
	//��ѯ��������
	public List<NewType> getAllType();
	
	//ɾ������  һ����һ����
	public  int delType(int tid);
	
	//ͨ������ ��ѯ����
	public NewType getType(int tid);
	
	//�޸Ĺ���
	public int updateType(NewType nt);
	
	//ʵ�ַ�ҳ��ʾ   ��ǰҳ������
	public List<NewType> getTypeByPage(int pageSize,int page);
	//��ѯ��ҳ��   ��ҳ��
	public int getTotalPage(int pageSize);
	
	
}
