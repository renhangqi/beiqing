package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.NewInfo;
import com.news.entity.NewType;
import com.news.service.NewInfoService;
import com.news.service.NewTypeService;
import com.news.service.impl.NewInfoServiceImpl;
import com.news.service.impl.NewTypeServiceImpl;

/**
 * Servlet implementation class GetNew
 */
@WebServlet("/GetNewServlet")
public class GetNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.查询单条新闻
		String nid=request.getParameter("nid");
	    NewInfoService newInfoService=new NewInfoServiceImpl();
	    NewInfo n=newInfoService.getNew(Integer.parseInt(nid));
	    request.setAttribute("n", n); //保存的是实体对象信息
	   
	   //2.查询新闻类别
	   //调用业务
	   NewTypeService newTypeService=new NewTypeServiceImpl();
	   List<NewType> list= newTypeService.getAllType();
	   request.setAttribute("types",list);
	   request.getRequestDispatcher("upNew.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
