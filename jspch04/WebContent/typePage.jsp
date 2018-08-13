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
 <table width="100%" border="1">
  <tr>
    <td>编号</td>
    <td>名称</td>
    <td>操作</td>
  </tr>
 <%
  //调用业务层获取某个数据
   NewTypeService newTypeService=new NewTypeServiceImpl();
 
    //定义页大小
    int pageSize=5;
    String number=request.getParameter("number"); //获取页码
    int curpage=number==null?1:Integer.parseInt(number);  //页码1
 
    //查询总页数
    int totalPage=newTypeService.getTotalPage(pageSize);
    
    //判断上一页 
    if(curpage<=0) curpage=1;
    //判断下一页 
    if(curpage>=totalPage) curpage=totalPage;
    
    
    //查询当前页的数据
    List<NewType> list=newTypeService.getTypeByPage(pageSize, curpage);
    //显示
    for(NewType nt:list){
 %>
 <tr>
    <td><%=nt.getTid() %></td>
    <td><%=nt.getTname()%></td>
     <td><a href="showUpdate.jsp?tid=<%=nt.getTid() %>">更新</a>  <a href="javascript:if(confirm('你确定想删除吗')){location.href='delTypeAction.jsp?tid=<%=nt.getTid() %>';}">删除</a><input type="button"  value="删除">
     <input type="hidden" value="<%=nt.getTid() %>"></td>
  </tr>
 <%   	
    }
 %>
</table>
 <hr/>
 每页<%=pageSize %>条，当前是第<%=curpage %>页，共<%= totalPage%>页
 <br/>
 <a href="typePage.jsp?number=1">首页</a> 
 <a href="typePage.jsp?number=<%=curpage-1%>">上一页</a> 
 <a href="typePage.jsp?number=<%=curpage+1%>">下一页</a>
 <a href="typePage.jsp?number=<%=totalPage%>">尾页</a>
 <hr/>
 <%
 for(int i=1;i<=totalPage;i++)
 {
	 %>
	 <a href="typePage.jsp?number=<%=i%>"><%=i %></a> 
	 <%
 }
 %>
 <hr> 
 转到：
 <select onchange="location.href='typePage.jsp?number='+this.value;">
 <option>请选择页码</option>
  <%
 for(int i=1;i<=totalPage;i++)
 {
	 %>
	<option <%=i==curpage?"selected=selected":"" %> value="<%=i%>">第<%=i%>页</option>
	 <%
 }
 %>
 </select>
</body>
</html>