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
  显示新闻主题及主题对应的新闻
 <table border=2>
   <tr>
     <td>主题编号</td> <td>主题名称</td>
   </tr>
   <c:forEach items="${types }" var="t">
    <tr>
     <td>${t.tid }</td> <td>${t.tname }</td>
   </tr>
     <tr>
     <td colspan="2">
          <table>
           <tr>
            <td>标题</td><td>时间</td><td>作者</td>
           </tr>
          <c:forEach items="${t.newInfos }" var="newinfo">
             <tr>
            <td>${newinfo.ntitle }</td><td>${newinfo.ntime }</td><td>${newinfo.nauthor }</td>
           </tr>
          </c:forEach>
          </table>
     </td>
   </tr>
   </c:forEach>
 </table>  
</body>
</html>