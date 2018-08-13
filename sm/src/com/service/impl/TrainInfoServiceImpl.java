package com.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.TrainInfoMapper;
import com.entity.TrainInfo;
import com.service.TrainInfoService;
import com.util.MyBatisUtil;

public class TrainInfoServiceImpl implements TrainInfoService {

	@Override
	public List<TrainInfo> getAllTrainInfo() {
		SqlSession sqlSession=null;
		try {
			 sqlSession=MyBatisUtil.getSession();
			 TrainInfoMapper  trainInfoMapper=sqlSession.getMapper(TrainInfoMapper.class);
			return trainInfoMapper.getAllTrainInfo();
		} catch (Exception e) {
			e.printStackTrace();  //log4j
		}finally {
			MyBatisUtil.closeSession();
		}
		return null;
	}

	@Override
	public int addTrainInfo(TrainInfo trainInfo) {
		int temp=-1;
		SqlSession sqlSession=null;
		try {
			 sqlSession=MyBatisUtil.getSession();
			 TrainInfoMapper  trainInfoMapper=sqlSession.getMapper(TrainInfoMapper.class);
			 temp=trainInfoMapper.insert(trainInfo);
			 sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();  //log4j
		}finally {
			MyBatisUtil.closeSession();
		}
		return temp;
	}

	@Override
	public TrainInfo selectByPrimaryKey(String trainNo) {
		SqlSession sqlSession=null;
		try {
			 sqlSession=MyBatisUtil.getSession();
			 TrainInfoMapper  trainInfoMapper=sqlSession.getMapper(TrainInfoMapper.class);
			return trainInfoMapper.selectByPrimaryKey(trainNo);
		} catch (Exception e) {
			e.printStackTrace();  //log4j
		}finally {
			MyBatisUtil.closeSession();
		}
		return null;
	}

}
