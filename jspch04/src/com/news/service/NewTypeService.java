package com.news.service;

import java.util.List;

import com.news.entity.NewType;

public interface NewTypeService {
   //������� 
	public int addType(NewType nt) ;
	
	//��ѯ��������
	public List<NewType> getAllType();

    /**
     *  ɾ������
     * @param tid ������
     * @return  Ӱ�������
     */
	public int delType(int tid);

	/**
	 * ��ѯ��������
	 * @param tid  ������
	 * @return  ����ʵ��
	 */
   public NewType getType(int tid);
   
   /**
    * �޸�����
    * @param nt  ʵ��
    * @return Ӱ������
    */
   public int updateType(NewType nt);
   
   /**
    *  ͨ��ҳ���ѯĳҳ��¼
    * @param pageSize ҳ��С
    * @param page  ҳ��
    * @return ��ǰҳ�ļ�¼
    */
   public List<NewType> getTypeByPage(int pageSize,int page);
   
   /**
    * ��ѯ��ҳ��
    * @param pageSize  ҳ��С 
    * @return ��ҳ��
    */
   public int getTotalPage(int pageSize);
   
   
 //��ѯ��������
 	public List<NewType> getAllType2();

}
