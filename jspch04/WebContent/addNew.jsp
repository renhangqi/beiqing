<%@page import="com.news.entity.NewType"%>
<%@page import="java.util.List"%>
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
<form action="AddNewServlet" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <p>新闻标题:
    <input type="text" name="textfield" id="textfield" />
  </p>
  <p>作者:
    <input type="text" name="textfield2" id="textfield2" />
  </p>
  <p>类型:
    <select name="select" id="select">
    <%
  //调用业务
   NewTypeService newTypeService=new NewTypeServiceImpl();
   List<NewType> list= newTypeService.getAllType();
   for(NewType nt:list){
	   %>
	    <option value="<%=nt.getTid()%>"><%=nt.getTname() %></option>
	   <%
   }
%>
    </select>
  </p>
  <p>内容:
    <label for="textarea"></label>
    <textarea name="textarea" id="textarea" cols="45" rows="5"></textarea>
  </p>
  <p>图片;
    <input type="file" name="fileField" id="fileField" />
  </p>
  <p>
    <input type="submit" name="button" id="button" value="添加新闻" />
  </p>
</form>
</body>
</html>