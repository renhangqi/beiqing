<%@page import="com.news.entity.NewInfo"%>
<%@page import="com.news.service.impl.NewInfoServiceImpl"%>
<%@page import="com.news.service.NewInfoService"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //上传文件
   FileItemFactory fif=new DiskFileItemFactory(); 
   ServletFileUpload sfu=new ServletFileUpload(fif);
   List<FileItem> list=sfu.parseRequest(request); //解析请求
   //上传图片
   FileItem fitem=list.get(4);
   String fname=fitem.getName(); 
   String expName=fname.substring(fname.lastIndexOf("."));
   List<String> fileType=new ArrayList<String>();
   fileType.add(".jpg"); 
   fileType.add(".jpeg");
   fileType.add(".gif");
   if(fileType.contains(expName)){  //存在上传
	   String savename=System.currentTimeMillis()+expName;
	   String path=application.getRealPath("upload")+"\\"+savename;
	   File file=new File(path);
	   fitem.write(file);  //上传
	    
	   //保存到数据库
	   //创建实体
	   NewInfo newinfo=new NewInfo();
	   newinfo.setNtitle(list.get(0).getString("utf-8"));
	   newinfo.setNcontent(list.get(3).getString("utf-8"));
	   newinfo.setNauthor(list.get(1).getString("utf-8"));
	   newinfo.setNtype(Integer.parseInt(list.get(2).getString()));  //取类型
	   //设置上传文件的路径
	   newinfo.setNpic(savename); //?????
	   
	   NewInfoService newInfoService=new NewInfoServiceImpl();
	   int temp=newInfoService.addNew(newinfo);
	   if(temp>0)
	   {
		   out.print("<script>alert('添加新闻成功'); location.href='addNew.jsp';</script>");   
	   }else
	   {
		    //删除图片 :  当图片保存成功，数据库操作失败，删除图片
		    file.delete();
		   out.print("<script>alert('添加新闻失败'); location.href='addNew.jsp';</script>");   
	   } 
   }else{
      out.print("<script>alert('你上传的文件格式不正确,添加新闻失败'); location.href='addNew.jsp';</script>");
   }
%>