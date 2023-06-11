package cn.studybigdata.javaee.servlet_api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AboutUs extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
	    
	    PrintWriter out = response.getWriter();
		out.println("<html>");
	    out.println("<head><title>关于我们</title></head>");
	    out.println("<body>");
	    out.println("<h1>关于我们</h1>");
	    out.println("<p>公司网址：www.studybigdata.cn</p>");
	    out.println("</body>");
	    out.println("</html>");		
	    
	    
//	    out.println("a的");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
