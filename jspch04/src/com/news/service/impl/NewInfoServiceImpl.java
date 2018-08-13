package com.news.service.impl;

import java.util.List;

import com.news.dao.NewInfoDao;
import com.news.dao.impl.NewInfoDaoImpl;
import com.news.entity.NewInfo;
import com.news.service.NewInfoService;

public class NewInfoServiceImpl implements NewInfoService {
    NewInfoDao newInfoDao=new NewInfoDaoImpl();
	@Override
	public int addNew(NewInfo info) {
		// TODO Auto-generated method stub
		return newInfoDao.addNew(info);
	}
	@Override
	public List<NewInfo> getAllNew() {
		// TODO Auto-generated method stub
		return newInfoDao.getAllNew();
	}
	@Override
	public NewInfo getNew(int nid) {
		// TODO Auto-generated method stub
		return newInfoDao.getNew(nid);
	}
}
