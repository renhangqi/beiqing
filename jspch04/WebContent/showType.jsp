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
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
  $(function(){
	 $("input[value='删除']").click(function(){
		  if(confirm("你确定想删除吗?")){
			  var tid=$(this).next().val();
			//  alert(tid);
			  location.href="delTypeAction.jsp?tid="+tid;
		  }
	 });   
	 
	 $(".del2").click(function(){
		  if(confirm("你确定想删除吗?")){
			//   alert("发异步请求到服务器实现删除?");
			var row= $(this).parent().parent();
			 var tid=$(this).prev().val();
			$.post("DelTypeServlet",{"tid":tid},function(data){
				if(data.result>0)
					{
					   row.remove();
					   //alert("删除成功");
					}
				else
					alert("删除失败");
			},"json");
		  }
	 });  
	  
  });
</script>
</head>
<body>
<a href="addType.jsp">添加</a>  <a href="showType.jsp">显示主题</a>

<table width="100%" border="1">
  <tr>
    <td>编号</td>
    <td>名称</td>
    <td>操作</td>
  </tr>
 <%
    //查询所有新闻主题 
    //调用业务
    NewTypeService newTypeService=new NewTypeServiceImpl();
    List<NewType> list= newTypeService.getAllType();
    for(NewType nt:list){
 %>
  <tr>
    <td><%=nt.getTid() %></td>
    <td><%=nt.getTname()%></td>
     <td><a href="showUpdate.jsp?tid=<%=nt.getTid() %>">更新</a>  <a href="javascript:if(confirm('你确定想删除吗')){location.href='typeAction.jsp?action=del&tid=<%=nt.getTid() %>';}">删除</a><input type="button"  value="删除">
     <input type="hidden" value="<%=nt.getTid() %>"><input type="button" class="del2"  value="异步删除">
     </td>
  </tr>
 <%   	
   }
 %>
</table>
</body>
</html>