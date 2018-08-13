package com.news.service;

import java.util.List;

import com.news.entity.NewInfo;

public interface NewInfoService {
	public int addNew(NewInfo info);
	
	public List<NewInfo> getAllNew();
	
	public NewInfo getNew(int nid) ;
}
