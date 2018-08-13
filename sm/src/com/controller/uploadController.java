package com.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class uploadController {
	@RequestMapping("uploadAction.do")
	public String uploadAction(HttpServletRequest request,String name,@RequestParam(value="file") CommonsMultipartFile file,Model model) {
	      	//第一方式:保存在应用程序服务器.
		    //获取上传的相关信息
//		    System.out.println("输入名称:"+name);
//		    System.out.println("文件名称:"+file.getOriginalFilename());
//		    System.out.println("文件类型:"+file.getContentType());
//		    System.out.println("文件大小:"+file.getSize());
		try {
			String path=request.getSession().getServletContext().getRealPath("upload");
			String uploadFileName=file.getOriginalFilename();//获取上传文件名
			String expname=uploadFileName.substring(uploadFileName.lastIndexOf("."));//扩展名
			String fileName=System.currentTimeMillis()+expname;  //保存文件名
			File targetFile=new File(path+"\\"+fileName);  //创建目录文件	
			file.transferTo(targetFile);//上传
			
			 //指定提示信息
			model.addAttribute("info", "上传成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("info", "上传失败 ");
		}
		return "upload.jsp";
	}
	@RequestMapping("download.do")
	public void download(HttpServletResponse response) {
		  //下载
		   //设置下载
		  response.setHeader("Content-Disposition","attachment;fileName=qng.mp3");
		  //设置响应文件类型
		  //response.setContentType("image/jpeg");  //报头
		  response.setContentType("audio/mp3");  //报头
		  try {
				  //添加响应的数据
				  //读取服务器图片文件的二进制数据
				  FileInputStream fis=new FileInputStream("d:\\青鸟之歌.mp3");
				  byte []bs=new byte[fis.available()];
				  fis.read(bs);
				  fis.close();
				  
				  //将字节数组输出响应流中
				 ServletOutputStream sos=response.getOutputStream();
				 sos.write(bs);
				 sos.close();
				 sos=null;
			} catch (Exception e) {
			  e.printStackTrace();
		    }
	}
}
