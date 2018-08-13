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
<a href="addType.jsp">添加</a>  <a href="showType.jsp">显示主题</a>
<br/>
<%
   String tid=request.getParameter("tid");
   //调用业务
   NewTypeService newTypeService=new NewTypeServiceImpl();
   NewType nt= newTypeService.getType(Integer.parseInt(tid));
%>
>>修改主题  通过编号查询单条主题
updateTypeAction.jsp?tid=<%=tid %>
<form action="typeAction.jsp?action=up" name="form1" method="post">
  主题编号:<input type="hidden" name="tid" readonly="readonly" value="<%=tid %>" /> 
  主题名称:<input type="text" name="tname" value="<%=nt.getTname() %>" /><br/>
  <input type="submit" value="修改" name="sum2"/>
  <input type="reset" value="清空" name="d"/>
</form>
</body>
</html>