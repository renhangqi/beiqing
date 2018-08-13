<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.news.entity.NewInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
所有闻新如下:
<table width="100%" border="1">
  <tr>
    <td>编号</td>
    <td>标题</td>
    <td>时间</td>
    <td>作者</td>
    <td>类型</td>
    <td>图片</td>
    <td>操作</td>
  </tr>
  <c:forEach items="${list}" var="n">
 <tr>
    <td>${n.nid }</td>
    <td>${n.ntitle }</td>
    <td>${n.ntime }</td>
    <td>${n.nauthor }</td>
    <td>${n.ntype }=${n.newType.tname }</td>
    <td>${n.npic }</td>
    <td>删除  <a href="GetNewServlet?nid=${n.nid }">修改</a></td>
  </tr>
  </c:forEach>
</table>
</body>
</html>