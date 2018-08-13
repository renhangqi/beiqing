package com.news.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * �������ݿ�Ĺ�����
 * @author ������
 * @version1.0
 */
public class BaseDao {
	//���������ݿ�Ĳ���
	private final String driverClass="com.mysql.cj.jdbc.Driver";
	private final String url="jdbc:mysql://localhost:3306/newsdb?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	private final String username="root";
	private final String password="123";
	
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	/**
	 * ��ȡjdbc�����Ӷ���
	 * @return  ���Ӷ���
	 */
	public Connection getConn() {
		try {
			Class.forName(this.driverClass);
			this.con=DriverManager.getConnection(this.url,this.username,this.password);
			return this.con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	/**
	 * ִ����ӣ��޸ģ�ɾ�����   
	 * �����õ�Ԥִ�ж���֧�ֲ�����sql
	 * ����Ӱ������
	 * @param sql  sql��䣬֧�ֲ�����
	 * @param params ����ֵ���޲δ�null
	 * @return  Ӱ������
	 */
	public int executeUpdate(String sql,Object []params) {
	    int temp=-1;
		try {
			this.getConn();  //��ȡ���Ӷ���
			ps=con.prepareStatement(sql); //Ԥִ�ж���
		    if(params!=null)
		    {
			    for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
		    }
		    temp=ps.executeUpdate();  //ִ�� 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    this.closeAll();
		}
		return temp;
	}

    
	/**
	 * ִ�в�ѯ ���ؽ����  
	 * @param selectsql  ��ѯ���֧�ֲ���
	 * @param params ����
	 * @return �����
	 */
	public ResultSet executeQuery(String selectsql,Object []params) {
		try {
			this.getConn(); //��ȡ���Ӷ���
			ps=con.prepareStatement(selectsql); //Ԥִ�ж���
			if(params!=null)
			 {
				  for (int i = 0; i < params.length; i++) {
				    ps.setObject(i+1, params[i]);
				  }
			 }
			rs=ps.executeQuery();  //ִ�� 
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//�ر���Դ����
	public void closeAll() {
		try {
			if(rs!=null) { rs.close(); rs=null;}
			if(ps!=null) { ps.close(); ps=null;}
			if(con!=null) { con.close(); con=null;}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
