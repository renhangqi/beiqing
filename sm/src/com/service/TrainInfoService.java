package com.service;

import java.util.List;

import com.entity.TrainInfo;

public interface TrainInfoService {
	 /**
	 * 查询所有火车信息
	 * @return  实体集合
	 */
	 public List<TrainInfo> getAllTrainInfo();
	 
	 /**
	  * 添加车次信息
	  * @param trainInfo
	  * @return  影响行数
	  */
	 public int addTrainInfo(TrainInfo trainInfo);

	 /**
	  * 查询单条
	  * @param trainNo  编号
	  * @return  实体
	  */
	 TrainInfo selectByPrimaryKey(String trainNo);
}
