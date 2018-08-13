package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.entity.Users;
import com.news.service.UserService;
import com.news.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        
		request.setCharacterEncoding("utf-8");
        String uname=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        
        //判断登入
        UserService userService=new UserServiceImpl();
        Users u=userService.getUsers(uname, pwd);
        if(u!=null) {
        	HttpSession session=request.getSession();
        	session.setAttribute("userinfo",u);
        	out.println("<script>alert('登入成功');location.href='main.jsp';</script>");
        }else {
        	out.println("<script>alert('登入失败');location.href='login.jsp';</script>");
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
