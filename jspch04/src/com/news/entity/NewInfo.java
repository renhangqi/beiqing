package com.news.entity;

public class NewInfo {
  private int nid;
  private  String ntitle;
  private String ncontent;
  private String ntime;
  private String nauthor;
  private int ntype;
  private String npic;
  
  
  //添加类别名秒
  private String tname;
  
  private NewType newType=new NewType();
  
  
public NewType getNewType() {
	return newType;
}
public void setNewType(NewType newType) {
	this.newType = newType;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public int getNid() {
	return nid;
}
public void setNid(int nid) {
	this.nid = nid;
}
public String getNtitle() {
	return ntitle;
}
public void setNtitle(String ntitle) {
	this.ntitle = ntitle;
}
public String getNcontent() {
	return ncontent;
}
public void setNcontent(String ncontent) {
	this.ncontent = ncontent;
}
public String getNtime() {
	return ntime;
}
public void setNtime(String ntime) {
	this.ntime = ntime;
}
public String getNauthor() {
	return nauthor;
}
public void setNauthor(String nauthor) {
	this.nauthor = nauthor;
}
public int getNtype() {
	return ntype;
}
public void setNtype(int ntype) {
	this.ntype = ntype;
}
public String getNpic() {
	return npic;
}
public void setNpic(String npic) {
	this.npic = npic;
}
  
}
