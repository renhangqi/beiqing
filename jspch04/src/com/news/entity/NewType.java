package com.news.entity;

import java.util.ArrayList;
import java.util.List;

//�������� 
public class NewType {
   private int tid;
   private String tname;
   
   //ʵ��ʵ����ʵ��Ĺ�ϵ  1�Զ�
   private List<NewInfo> newInfos=new ArrayList<>();
   
   
   
public List<NewInfo> getNewInfos() {
	return newInfos;
}
public void setNewInfos(List<NewInfo> newInfos) {
	this.newInfos = newInfos;
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
   
}
