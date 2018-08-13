package com.service;

import java.util.List;

import com.entity.TrainInfo;

public interface TrainInfoService {
	 /**
	 * ��ѯ���л���Ϣ
	 * @return  ʵ�弯��
	 */
	 public List<TrainInfo> getAllTrainInfo();
	 
	 /**
	  * ��ӳ�����Ϣ
	  * @param trainInfo
	  * @return  Ӱ������
	  */
	 public int addTrainInfo(TrainInfo trainInfo);

	 /**
	  * ��ѯ����
	  * @param trainNo  ���
	  * @return  ʵ��
	  */
	 TrainInfo selectByPrimaryKey(String trainNo);
}
