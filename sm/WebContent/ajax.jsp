<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<!--jquery.easyui.min.js包含了easyUI中的所有插件-->
	<script src="js/jquery.easyui.min.js"></script>

<script type="text/javascript">
$(function(){  //加载
	 $("#but1").click(function(){
		 //发送异步请求到服务器处理
		 $.post("getData2.do",null,function(data){
			 //客户端的处理代码 
			 var table="<table><tr><td>车次</td><td>出发地-到达地</td><td>发车时间-到达时间</td><td>类型</td></tr>";
			 for(var i=0;i<data.length;i++){
				table=table+"<tr><td>"+data[i].trainNo+"</td><td>"+data[i].startStation+"-"+data[i].arrivalStation+"</td><td>"+data[i].startTime+"-"+data[i].arrivalTime+"</td><td>"+data[i].type+"</td></tr>"; 
			 } 
			 table=table+"</table>";
			 $("#div1").html(table);
		 },"json");
	 }); 
	 
	 
	 //加载显示
	 $('#dg').datagrid({   
		    url:'getData2.do',   
		    columns:[[   
		        {title:'车次',field:'trainNo',width:100},   
		        {title:'出发地',field:'startStation',width:100},   
		        {title:'到达地',field:'arrivalStation',width:100,align:'right'}, 
		        {title:'发车时间',field:'startTime',width:100,align:'right'},
		        {title:'到达时间',field:'arrivalTime',width:100,align:'right'},
		        {title:'类别',field:'type',width:100,align:'right'},
		        {title:'运行时间',field:'runtime',width:100,align:'right'},
		        {title:'里程',field:'mile',width:100,align:'right'}
		    ]]   
		});  
	
});
</script>
</head>
<body>

<input type="button"  id="but1" value="获取服务器数据:显示所有火车站信息" name="but1" />
 <div id="div1"></div>
 <!-- 
 <table class="easyui-datagrid" style="width:400px;height:250px"  
        data-options="url:'getData2.do',fitColumns:true,singleSelect:true">  
    <thead>  
        <tr>  
            <th data-options="field:'trainNo',width:100">车次</th>  
            <th data-options="field:'startStation',width:100">出发地</th>  
            <th data-options="field:'arrivalStation',width:100,align:'right'">到达地</th>  
        </tr>  
    </thead>  
</table>  
 -->
 <table id="dg"></table> 
</body>
</html>