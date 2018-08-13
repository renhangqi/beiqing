package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.NewType;
import com.news.service.NewTypeService;
import com.news.service.impl.NewTypeServiceImpl;

/**
 * Servlet implementation class ShowTypeNewServlet
 */
@WebServlet("/ShowTypeNewServlet")
public class ShowTypeNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTypeNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //查询所 有主题
		  NewTypeService newTypeService=new NewTypeServiceImpl();
		  List<NewType> list=newTypeService.getAllType2();
		
		  //设置到作用域
		  request.setAttribute("types", list);
		  request.getRequestDispatcher("typenews.jsp").forward(request, response);
		  
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
