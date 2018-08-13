<%@page import="com.news.entity.NewType"%>
<%@page import="java.util.List"%>
<%@page import="com.news.service.impl.NewTypeServiceImpl"%>
<%@page import="com.news.service.NewTypeService"%>
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
修改新闻
<form action="AddNewServlet" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <p>标题:
    <input type="text" name="textfield"  value="${n.ntitle }" id="textfield" />
  </p>
  <p>作者:
    <input type="text" name="textfield2" value="${n.nauthor }" id="textfield2" />
  </p>
  <p>类型:
    <select name="select" id="select">
		  <c:forEach items="${types }" var="nt">
		    <c:if test="${nt.tid==n.ntype }">
		      <option selected="selected"  value="${nt.tid }">${nt.tname }</option>
  			</c:if>
  			   <c:if test="${nt.tid!=n.ntype }">
		      <option   value="${nt.tid }">${nt.tname }</option>
  			</c:if>
		 </c:forEach>
    </select>
  </p>
  <p>内容:
    <label for="textarea"></label>
    <textarea name="textarea" id="textarea" cols="45" rows="5">${n.ncontent}</textarea>
  </p>
  <p>图片
      <img src="upload/${n.npic }" width="100" height="100">
    <input type="file" name="fileField" id="fileField" />
  </p>
  <p>
    <input type="submit" name="button" id="button" value="修改新闻" />
  </p>
</form>
</body>
</html>