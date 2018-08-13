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
 
   //取值
 request.setCharacterEncoding("utf-8");
   String tname=request.getParameter("tname");
   String tid=request.getParameter("tid");
   //创建实体 
   NewType nt=new NewType();
   nt.setTid(Integer.parseInt(tid));  //??????
   nt.setTname(tname);
 
    //调用业务
    NewTypeService newTypeService=new NewTypeServiceImpl();
     int  temp=newTypeService.updateType(nt);
     
     if(temp>0)
   	  out.print("<script>alert('修改成功');location.href='showType.jsp';</script>");
    else
   	  out.print("<script>alert('修改失败');location.href='showType.jsp';</script>"); 
 %>
</body>
</html>