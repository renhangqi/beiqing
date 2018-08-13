package com.news.service;

import java.util.List;

import com.news.entity.NewType;

public interface NewTypeService {
   //添加主题 
	public int addType(NewType nt) ;
	
	//查询所有主题
	public List<NewType> getAllType();

    /**
     *  删除主题
     * @param tid 主题编号
     * @return  影响的行数
     */
	public int delType(int tid);

	/**
	 * 查询单个主题
	 * @param tid  主题编号
	 * @return  主题实体
	 */
   public NewType getType(int tid);
   
   /**
    * 修改主题
    * @param nt  实体
    * @return 影响行数
    */
   public int updateType(NewType nt);
   
   /**
    *  通过页码查询某页记录
    * @param pageSize 页大小
    * @param page  页码
    * @return 当前页的记录
    */
   public List<NewType> getTypeByPage(int pageSize,int page);
   
   /**
    * 查询总页数
    * @param pageSize  页大小 
    * @return 总页数
    */
   public int getTotalPage(int pageSize);
   
   
 //查询所有主题
 	public List<NewType> getAllType2();

}
