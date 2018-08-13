<%@page import="com.news.entity.NewType"%>
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
<%
 //1.取值
 request.setCharacterEncoding("utf-8");
 String tname=request.getParameter("tname");
 
 //将数据封装成实体
 NewType nt=new NewType();
 nt.setTname(tname);
 
 //2.调业务
 NewTypeService newTypeService=new NewTypeServiceImpl();
 int temp=newTypeService.addType(nt);
 if(temp>0)
	  out.print("<script>alert('添加成功');location.href='addType.jsp';</script>");
 else
	  out.print("<script>alert('添加失败');location.href='addType.jsp';</script>");
%>
</body>
</html>