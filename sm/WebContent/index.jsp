<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 显示所有火车信息
<table width="100%" border="1">
  <tr>
    <td>操作</td>
    <td>车次 </td>
    <td>发车--到达</td>
    <td>发时-到时</td>
    <td>车型</td>
    <td>运行时间</td>
     <td>操作</td>
  </tr>
  <c:forEach items="${list }" var="t">
  <tr>
    <td><input type="checkbox" name="cb" value="${t.trainNo }"/></td>
    <td>${t.trainNo }</td>
	<td>${t.startStation }--${t.arrivalStation }</td>
    <td>${t.startTime }--${t.arrivalTime }</td>
   	<td>${t.type }</td>
    <td>${t.runtime }</td>
    <td><a href="getTrainInfo.do?no=${t.trainNo }">修改</a></td>
  </tr>
  </c:forEach>
</table>
</body>
</html>