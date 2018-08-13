package com.news.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.news.dao.NewInfoDao;
import com.news.entity.NewInfo;
import com.news.entity.NewType;

public class NewInfoDaoImpl extends BaseDao implements NewInfoDao {

	@Override
	public int addNew(NewInfo info) {
		String sql="INSERT INTO newinfo(n_title,n_content,n_time,n_author,n_type,n_pic) VALUES(?,?,NOW(),?,?,?)";
		Object objs[]= {
			info.getNtitle(),
			info.getNcontent(),
			info.getNauthor(),
			info.getNtype(),
			info.getNpic()
		};
		return this.executeUpdate(sql, objs);
	}

	@Override
	public List<NewInfo> getAllNew() {
		String sql="SELECT newinfo.*,t_name FROM newinfo  INNER JOIN new_type\r\n" + 
				"ON newinfo.`n_type`=new_type.`t_id`";
		List<NewInfo> list=null;
		try {
			ResultSet rs=this.executeQuery(sql, null);
			list=new ArrayList<NewInfo>();
			while(rs.next()) {
				//����ʵ��
				NewInfo n=new NewInfo();
			   n.setNid(rs.getInt(1));
			   n.setNtitle(rs.getString(2));
			   //n.setNcontent(rs.getString(3));
			   n.setNtime(rs.getString(4));
			   n.setNauthor(rs.getString(5));
			   n.setNtype(rs.getInt(6));
			   n.setNpic(rs.getString(7));
			   
			   //��������������  
			   n.getNewType().setTname(rs.getString(8));
			   
				//��ʵ����Ӽ���
				list.add(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list;
	}

	@Override
	public NewInfo getNew(int nid) {
		String sql="select * from newinfo where n_id=?";
		NewInfo n=null;
		try {
			ResultSet rs=this.executeQuery(sql, new Object[] {nid});
			if(rs.next()) {
				//����ʵ��
				 n=new NewInfo();
			   n.setNid(rs.getInt(1));
			   n.setNtitle(rs.getString(2));
			   n.setNcontent(rs.getString(3));
			   n.setNtime(rs.getString(4));
			   n.setNauthor(rs.getString(5));
			   n.setNtype(rs.getInt(6));
			   n.setNpic(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return n;
	}

	@Override
	public List<NewInfo> getNewByType(int tid) {
		String sql="SELECT * FROM newinfo WHERE n_type=?";
		List<NewInfo> list=null;
		try {
			ResultSet rs=this.executeQuery(sql, new Object[] {tid});
			list=new ArrayList<NewInfo>();
			while(rs.next()) {
				//����ʵ��
				NewInfo n=new NewInfo();
			   n.setNid(rs.getInt(1));
			   n.setNtitle(rs.getString(2));
			   //n.setNcontent(rs.getString(3));
			   n.setNtime(rs.getString(4));
			   n.setNauthor(rs.getString(5));
			   n.setNtype(rs.getInt(6));
			   n.setNpic(rs.getString(7));
				//��ʵ����Ӽ���
				list.add(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list;
	}
}
