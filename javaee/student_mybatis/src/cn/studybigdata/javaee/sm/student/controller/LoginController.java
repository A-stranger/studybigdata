package cn.studybigdata.javaee.sm.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.studybigdata.javaee.sm.student.dao.StudentDao;
import cn.studybigdata.javaee.sm.student.pojo.Student;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String msg="";
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(username!=null && password!=null){

			Student student = new Student();
			student.setAccount(username);
			student.setPassword(password);

			StudentDao studentDao = new StudentDao();

			try {
				List<Student> studentList = studentDao.search(student);
				if(studentList.size()>0){
// 在这里补写代码


					HttpSession session = request.getSession();
					session.setAttribute("account", studentList.get(0));
					response.sendRedirect("StudentController");


				}else{
					msg = "用户名或密码不正确";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
