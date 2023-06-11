package cn.studybigdata.javaee.servlet_api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
	   
	    String username = (String) request.getParameter("username");
	    String password = (String) request.getParameter("password");
		
	    if(username.equals("张三") && password.equals("123456")){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect("Index");
			
//			response.getWriter().append(username+" 登录成功");
	    }
	}

}
