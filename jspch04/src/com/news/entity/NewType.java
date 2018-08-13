package com.news.entity;

import java.util.ArrayList;
import java.util.List;

//新闻主题 
public class NewType {
   private int tid;
   private String tname;
   
   //实现实体与实体的关系  1对多
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
