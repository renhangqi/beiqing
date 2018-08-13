package com.dao;

import java.util.List;

import com.entity.TrainInfo;

public interface TrainInfoMapper {
	 public List<TrainInfo> getAllTrainInfo();
 	
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table train_info
     *
     * @mbggenerated Thu Aug 09 14:34:49 CST 2018
     */
    int deleteByPrimaryKey(String trainNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table train_info
     *
     * @mbggenerated Thu Aug 09 14:34:49 CST 2018
     */
    int insert(TrainInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table train_info
     *
     * @mbggenerated Thu Aug 09 14:34:49 CST 2018
     */
    int insertSelective(TrainInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table train_info
     *
     * @mbggenerated Thu Aug 09 14:34:49 CST 2018
     */
    TrainInfo selectByPrimaryKey(String trainNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table train_info
     *
     * @mbggenerated Thu Aug 09 14:34:49 CST 2018
     */
    int updateByPrimaryKeySelective(TrainInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table train_info
     *
     * @mbggenerated Thu Aug 09 14:34:49 CST 2018
     */
    int updateByPrimaryKey(TrainInfo record);
}