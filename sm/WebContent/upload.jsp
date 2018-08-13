<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>${info }</center>
<form action="uploadAction.do" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <p>名称:
    <input type="text" name="name" id="textfield" />
  </p>
  <p>图片:
    <input type="file" name="file" id="fileField" />
  </p>
  <p>
    <input type="submit" name="button" id="button" value="上传" />
  </p>
</form>
</body>
</html>