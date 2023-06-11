package cn.studybigdata.javaee.servlet_api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Hello() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
	    
	    String username = (String) request.getParameter("username");

	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>a servlet</title></head>");
	    out.println("<body>");
	    out.println("Hello! " +username);
	    out.println("</body>");
	    out.println("</html>");	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");

	    String user = (String) request.getParameter("username");
	    String pwd = (String) request.getParameter("password");
	    String result = "Post登录失败！";
	    if(user.equals("张三") && pwd.equals("123456")){
	    	result = " Post登录成功！";
	    }
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>a servlet</title></head>");
	    out.println("<body>");
	    out.println("Hello! " +user+": "+result);
	    out.println("</body>");
	    out.println("</html>");	
	}


	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");

	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>a servlet</title></head>");
	    out.println("<body>");
	    out.println("您发送了一个Delete请求! ");
	    out.println("</body>");
	    out.println("</html>");		
	    }


	@Override
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");

	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>a servlet</title></head>");
	    out.println("<body>");
	    out.println("您发送了一个Delete请求! ");
	    out.println("</body>");
	    out.println("</html>");	
	}


	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");

	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>a servlet</title></head>");
	    out.println("<body>");
	    out.println("您发送了一个Options请求! ");
	    out.println("</body>");
	    out.println("</html>");	
	}


	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");

	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>a servlet</title></head>");
	    out.println("<body>");
	    out.println("您发送了一个Put请求! ");
	    out.println("</body>");
	    out.println("</html>");	
	}
}
