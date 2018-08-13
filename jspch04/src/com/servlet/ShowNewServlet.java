package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.NewInfo;
import com.news.service.NewInfoService;
import com.news.service.impl.NewInfoServiceImpl;

/**
 * Servlet implementation class ShowNewServlet
 */
@WebServlet("/ShowNewServlet")
public class ShowNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     //调用业务:查询所有新闻
		 NewInfoService newInfoService=new NewInfoServiceImpl();
		 List<NewInfo> list= newInfoService.getAllNew();
		
		//跳转到某个jsp显示
	     //利用请求作用域跳转
		 request.setAttribute("list",list);
		 request.getRequestDispatcher("showNew.jsp").forward(request, response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
