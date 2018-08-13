package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.news.entity.NewInfo;
import com.news.service.NewInfoService;
import com.news.service.impl.NewInfoServiceImpl;

/**
 * Servlet implementation class AddNewServlet
 */
@WebServlet("/AddNewServlet")
public class AddNewServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	    try {
	   //ʵ���������
	  //�ϴ��ļ�
	    FileItemFactory fif=new DiskFileItemFactory(); 
	    ServletFileUpload sfu=new ServletFileUpload(fif);
	    List<FileItem> list=sfu.parseRequest(request); //��������
	    //�ϴ�ͼƬ
	    FileItem fitem=list.get(4);
	    String fname=fitem.getName(); 
	    String expName=fname.substring(fname.lastIndexOf("."));
	    List<String> fileType=new ArrayList<String>();
	    fileType.add(".jpg"); 
	    fileType.add(".jpeg");
	    fileType.add(".gif");
	    if(fileType.contains(expName)){  //�����ϴ�
	 	   String savename=System.currentTimeMillis()+expName;
	 	   String path=request.getServletContext().getRealPath("upload")+"\\"+savename;
	 	   File file=new File(path);
	 	   fitem.write(file);  //�ϴ�
	 	    
	 	   //���浽���ݿ�
	 	   //����ʵ��
	 	   NewInfo newinfo=new NewInfo();
	 	   newinfo.setNtitle(list.get(0).getString("utf-8"));
	 	   newinfo.setNcontent(list.get(3).getString("utf-8"));
	 	   newinfo.setNauthor(list.get(1).getString("utf-8"));
	 	   newinfo.setNtype(Integer.parseInt(list.get(2).getString()));  //ȡ����
	 	   //�����ϴ��ļ���·��
	 	   newinfo.setNpic(savename); //?????
	 	   
	 	   NewInfoService newInfoService=new NewInfoServiceImpl();
	 	   int temp=newInfoService.addNew(newinfo);
	 	   if(temp>0)
	 	   {
	 		   out.print("<script>alert('������ųɹ�'); location.href='addNew.jsp';</script>");   
	 	   }else
	 	   {
	 		    //ɾ��ͼƬ :  ��ͼƬ����ɹ������ݿ����ʧ�ܣ�ɾ��ͼƬ
	 		    file.delete();
	 		   out.print("<script>alert('�������ʧ��'); location.href='addNew.jsp';</script>");   
	 	   } 
	    }else{
	       out.print("<script>alert('���ϴ����ļ���ʽ����ȷ,�������ʧ��'); location.href='addNew.jsp';</script>");
	    }
	
	    } catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
