<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
添加车次信息<br/>
 <center>${info }</center>
<form id="form1" name="form1" method="post" action="addTrainInfo.do">
  <p>车次:
    <input type="text" name="trainNo" id="textfield" />
  </p>
  <p>出发地:
    <input type="text" name="startStation" id="textfield2" />
  </p>
  <p>到达地:
    <input type="text" name="arrivalStation" id="textfield3" />
  </p>
  <p>发车时间:
    <input type="text" name="startTime" id="textfield4" />
  </p>
  <p>到达时间:
    <input type="text" name="arrivalTime" id="textfield5" />
  </p>
  <p>类型:
    <input type="text" name="type" id="textfield6" />
  </p>
  <p>运行时间：<input type="date" name="runtime" /></p>
   <p>里程：<input type="text" name="mile" /></p>
  <input type="submit" name="ss" value="添加" />
  
</form>
</body>
</html>