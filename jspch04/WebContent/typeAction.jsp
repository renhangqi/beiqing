<%@page import="com.news.service.impl.NewTypeServiceImpl"%>
<%@page import="com.news.service.NewTypeService"%>
<%@page import="com.news.entity.NewType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
NewTypeService newTypeService=new NewTypeServiceImpl();
   //实现多个功能
   //传操作
   	  request.setCharacterEncoding("utf-8");
  String action=request.getParameter("action");
  String tid=request.getParameter("tid");
  String tname=request.getParameter("tname");
  //通过操作判断执行相应的功能
  if(action.equals("add")){	    
	  //将数据封装成实体
	  NewType nt=new NewType();
	  nt.setTname(tname);
	  //2.调业务
	  int temp=newTypeService.addType(nt);
	  if(temp>0)
	 	  out.print("<script>alert('添加成功');location.href='addType.jsp';</script>");
	  else
	 	  out.print("<script>alert('添加失败');location.href='addType.jsp';</script>");
  }
  
  if(action.equals("del")){
	  //调用业务层
	  int temp=newTypeService.delType(Integer.parseInt(tid));
	  if(temp>0)
		  out.print("<script>alert('删除成功');location.href='showType.jsp';</script>");
	  else
		  out.print("<script>alert('删除失败');location.href='showType.jsp';</script>");
  
  }

  if(action.equals("up")){
	    //创建实体 
	    NewType nt=new NewType();
	    nt.setTid(Integer.parseInt(tid));  //??????
	    nt.setTname(tname);
	     //调用业务
	      int  temp=newTypeService.updateType(nt);
	      if(temp>0)
	    	  out.print("<script>alert('修改成功');location.href='showType.jsp';</script>");
	     else
	    	  out.print("<script>alert('修改失败');location.href='showType.jsp';</script>"); 
 
	  
  }
%>