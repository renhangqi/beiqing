package com.news.service.impl;

import java.util.List;

import com.news.dao.NewInfoDao;
import com.news.dao.NewTypeDao;
import com.news.dao.impl.NewInfoDaoImpl;
import com.news.dao.impl.NewTypeDaoImpl;
import com.news.entity.NewInfo;
import com.news.entity.NewType;
import com.news.service.NewTypeService;

public class NewTypeServiceImpl implements NewTypeService {
	//�������ݷ��ʲ�
	NewTypeDao newTypeDao=new NewTypeDaoImpl();
	NewInfoDao newInfoDao=new NewInfoDaoImpl();
	
	@Override
	public int addType(NewType nt) {
		return newTypeDao.addType(nt);
	}


	@Override
	public int delType(int tid) {
	   
		return newTypeDao.delType(tid);
	}

	@Override
	public NewType getType(int tid) {
		// TODO Auto-generated method stub
		return newTypeDao.getType(tid);
	}

	@Override
	public int updateType(NewType nt) {
		return newTypeDao.updateType(nt);
	}

	@Override
	public List<NewType> getTypeByPage(int pageSize, int page) {
	    
		return newTypeDao.getTypeByPage(pageSize, page);
	}

	@Override
	public int getTotalPage(int pageSize) {
		// TODO Auto-generated method stub
		return newTypeDao.getTotalPage(pageSize); //�����ܼ�¼��
	}
	

    //��ѯ��������
	public List<NewType> getAllType() {
		// TODO Auto-generated method stub
		return newTypeDao.getAllType();
	}


	//��ѯ�����������⼰��Ӧ������
	public List<NewType> getAllType2() {
		
		//��ѯ������������
		List<NewType> list=newTypeDao.getAllType();
		//ѭ����������Ӧ������
		for(int i=0;i<list.size();i++) {
			NewType nt= list.get(i);
			int tid=nt.getTid();
			//ͨ��tid��ѯ��Ӧ���ż���
		    List<NewInfo> news=newInfoDao.getNewByType(tid);
		    //���������

		    //������
		    nt.setNewInfos(news);
		}
		return list;
	}
}
