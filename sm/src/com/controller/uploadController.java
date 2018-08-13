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
	      	//��һ��ʽ:������Ӧ�ó��������.
		    //��ȡ�ϴ��������Ϣ
//		    System.out.println("��������:"+name);
//		    System.out.println("�ļ�����:"+file.getOriginalFilename());
//		    System.out.println("�ļ�����:"+file.getContentType());
//		    System.out.println("�ļ���С:"+file.getSize());
		try {
			String path=request.getSession().getServletContext().getRealPath("upload");
			String uploadFileName=file.getOriginalFilename();//��ȡ�ϴ��ļ���
			String expname=uploadFileName.substring(uploadFileName.lastIndexOf("."));//��չ��
			String fileName=System.currentTimeMillis()+expname;  //�����ļ���
			File targetFile=new File(path+"\\"+fileName);  //����Ŀ¼�ļ�	
			file.transferTo(targetFile);//�ϴ�
			
			 //ָ����ʾ��Ϣ
			model.addAttribute("info", "�ϴ��ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("info", "�ϴ�ʧ�� ");
		}
		return "upload.jsp";
	}
	@RequestMapping("download.do")
	public void download(HttpServletResponse response) {
		  //����
		   //��������
		  response.setHeader("Content-Disposition","attachment;fileName=qng.mp3");
		  //������Ӧ�ļ�����
		  //response.setContentType("image/jpeg");  //��ͷ
		  response.setContentType("audio/mp3");  //��ͷ
		  try {
				  //�����Ӧ������
				  //��ȡ������ͼƬ�ļ��Ķ���������
				  FileInputStream fis=new FileInputStream("d:\\����֮��.mp3");
				  byte []bs=new byte[fis.available()];
				  fis.read(bs);
				  fis.close();
				  
				  //���ֽ����������Ӧ����
				 ServletOutputStream sos=response.getOutputStream();
				 sos.write(bs);
				 sos.close();
				 sos=null;
			} catch (Exception e) {
			  e.printStackTrace();
		    }
	}
}
