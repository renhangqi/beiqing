<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript" type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	  //点击事件
	  $("#but1").click(function(){
		  //发异步请求获取数据
		  $.post("Server.jsp",null,function (data){
			   //1.以字符串的方式接收返回的json
			   //使用$.parseJSON将字符串转化为json对象
			   //var jsonObj=$.parseJSON(data);
			   //alert(jsonObj[1]);
			   
			   //2.指定服务返回的字符串为json对象 :
			   //$.post("Server.jsp",null,function (data){ },"json");
			    //alert(data);
			    
			    //在客户端获取服务器返回的数据(Json)进行处理
			    var str="<table border=1><tr><td>编号</td><td>名称</td></tr>";
			    for(var i=0;i<data.length;i++){
			    	str=str+"<tr><td>"+data[i].tid+"</td><td>"+data[i].tname+"</td></tr>";
			    }
			    var str=str+"</table>";
			    $("#div1").html(str);
			    
		  },"json");
		  
	  });
	 
 });

</script>
</head>
<body>
 <input value="显示所新闻类别" name="ss" type="button" id="but1" />
 <div id="div1"></div>
</body>
</html>