<%@page import="com.google.gson.Gson"%>
<%@page import="com.news.entity.NewType"%>
<%@page import="java.util.List"%>
<%@page import="com.news.service.impl.NewTypeServiceImpl"%>
<%@page import="com.news.service.NewTypeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 //服务器输出的内容就是返回给客户端的数据
  //1.返回字符串
 //String str="hello";
 //out.print(str);
 
 //2.返回html
 //out.print("<ul><li>张三</li><li>麻子</li><li>李四</li></ul>");
 
 //3.使用Json返回三个人的姓名
 // out.print("[\"张三\",\"李四\",\"麻子\"]");
 //out.print("{\"xh\":101,\"name\":\"赵洋\"}");

  //调用业务
  NewTypeService newTypeService=new NewTypeServiceImpl();
  List<NewType> list=newTypeService.getAllType();

   //将java对象转化为json进行返回
   //1.利用拼接json字符串的方法
   /*StringBuffer jsonStr=new StringBuffer("[");
   for(NewType nt:list){
	   jsonStr.append("{\"tid\":"+nt.getTid()+",\"tname\":\""+nt.getTname()+"\"},");
   }
   jsonStr.deleteCharAt(jsonStr.length()-1); //删除最后的,
   jsonStr.append("]");
   out.print(jsonStr);
   */
   
   //2.使用Google的Gson工具包将java对象转化json对象
    //2.1导入Gson的jar包
    //2.2创建Gson对象
    Gson gson=new Gson();
    //2.3使用toJson方法将java对象转化为字符串
    String jsonStr=gson.toJson(list);
    out.print(jsonStr);
%>

