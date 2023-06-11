package cn.studybigdata.javaee.servlet_api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
		    response.setCharacterEncoding("utf-8");
		    request.setCharacterEncoding("utf-8");
		   	
			String username = "未登录";
			HttpSession session = request.getSession();
			if(session.getAttribute("username")!=null){
				username  = (String) session.getAttribute("username");
			}
		    PrintWriter out = response.getWriter();
		    out.println("<html>");
		    out.println("<head><title>首页</title></head>");
		    out.println("<body>");
		    out.println("当前登录用户: " +username);
		    out.println("</body>");
		    out.println("</html>");	
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    }

}
