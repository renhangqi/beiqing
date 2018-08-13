<%@page import="com.news.service.impl.NewTypeServiceImpl"%>
<%@page import="com.news.service.NewTypeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
实现删除新闻类别
<%
  //获取删除的编号
  String tid=request.getParameter("tid");
 
  //调用业务层
  NewTypeService newTypeService=new NewTypeServiceImpl();
  int temp=newTypeService.delType(Integer.parseInt(tid));
  
  if(temp>0)
	  out.print("<script>alert('删除成功');location.href='showType.jsp';</script>");
  else
	  out.print("<script>alert('删除失败');location.href='showType.jsp';</script>");
%>
</body>
</html>