package com.news.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.news.dao.NewTypeDao;
import com.news.entity.NewType;

public class NewTypeDaoImpl extends BaseDao implements NewTypeDao {

	@Override
	public int addType(NewType nt) {
		String sql="insert into new_type(t_name) values(?)";
		return this.executeUpdate(sql, new Object[] {nt.getTname()});
	}

	@Override
	public List<NewType> getAllType() {
		String sql="select * from new_type";
		List<NewType> list=null;
		try {
			ResultSet rs=this.executeQuery(sql, null);
			list=new ArrayList<NewType>();
			while(rs.next()) {
				//创建实体
				NewType nt=new NewType();
				nt.setTid(rs.getInt(1));
				nt.setTname(rs.getString(2));
				//将实体添加集合
				list.add(nt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list;
	}

	
	@Override
	public int delType(int tid) {
	   String sql="delete from new_type where t_id=?";
		return this.executeUpdate(sql, new Object[] {tid});
	}

	@Override
	public NewType getType(int tid) {
		NewType nt=null;
		String sql="select * from new_type where t_id=?";
		try {
		ResultSet rs=this.executeQuery(sql,new Object[] {tid});
			if(rs.next()) {
				nt=new NewType();
				nt.setTid(rs.getInt(1));
				nt.setTname(rs.getString(2));
				//...
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return nt;
	}

	@Override
	public int updateType(NewType nt) {
		String sql="update  new_type set t_name=? where t_id=?";
		return this.executeUpdate(sql, new Object[] {nt.getTname(),nt.getTid()});
	}

	@Override
	public List<NewType> getTypeByPage(int pageSize, int page) {
		String sql="select * from new_type limit ?,?";
		int pos=(page-1)*pageSize;  //计算提取记录开始位置
		List<NewType> list=null;	
		try {
			ResultSet rs=this.executeQuery(sql, new Object[] {pos,pageSize});
			list=new ArrayList<NewType>();
			while(rs.next()) {
				//创建实体
				NewType nt=new NewType();
				nt.setTid(rs.getInt(1));
				nt.setTname(rs.getString(2));
				//将实体添加集合
				list.add(nt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list;
	}

	@Override
	public int getTotalPage(int pageSize) {
		int totalpage=0;
		String sql="select count(1) from new_type";
		try {
		 ResultSet rs=this.executeQuery(sql,null);
		 if(rs.next()) {
			 int totalRecord=rs.getInt(1);
			/* if(totalRecord%pageSize==0) {
				 totalpage= totalRecord/pageSize;
			 }else
			 {
				 totalpage= totalRecord/pageSize+1;
			 }*/
			 totalpage=(int)Math.ceil(totalRecord*1.0/pageSize);
		 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return totalpage;
	}


}
