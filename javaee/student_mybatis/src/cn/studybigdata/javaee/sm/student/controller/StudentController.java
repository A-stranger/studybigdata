package cn.studybigdata.javaee.sm.student.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.studybigdata.javaee.sm.student.dao.StudentDao;
import cn.studybigdata.javaee.sm.student.dao.TypeDao;
import cn.studybigdata.javaee.sm.student.pojo.Student;
import cn.studybigdata.javaee.sm.student.pojo.Type;


public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String operation = request.getParameter("operation");

		if(operation==null){
			query(request,response);
		}else if("delete".equals(operation)){
			deleteStudent(request,response);
		}else if("find".equals(operation)){
			findStudent(request,response);
		}else if("add".equals(operation)){
			addStudent(request,response);
		}else if("update".equals(operation)){
			updateStudent(request,response);
		}else if("getById".equals(operation)){
			getStudentById(request,response);
		}
	}

	//添加学生操作
void addStudent(HttpServletRequest request, HttpServletResponse response){
// 在这里补写代码


	StudentDao studentDao = new StudentDao();
	Student student = new Student();
	student.setName(request.getParameter("name"));
	student.setAge(Integer.parseInt(request.getParameter("age")));
	student.setSex(request.getParameter("sex"));
	student.setAccount(request.getParameter("account"));
	student.setPassword(request.getParameter("password"));

	TypeDao typeDao = new TypeDao();
	Type type = typeDao.getById(Integer.parseInt(request.getParameter("typeId")));
	student.setType(type);

	try {
		studentDao.addStudent(student);
		response.sendRedirect("StudentController");
	}catch (IOException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}


}

//查询所有学生操作
void query(HttpServletRequest request, HttpServletResponse response){
// 在这里补写代码


	StudentDao studentDao = new StudentDao();
	//根据StudentDao实例获得所有学生的信息
	List<Student> list=null;
	try {
		Student student = new Student();
		list = studentDao.search(student);
	} catch (Exception e) {
		e.printStackTrace();
	}
	//将学生信息存入请求域
	request.setAttribute("studentList", list);
	try {
		request.getRequestDispatcher("view.jsp").forward(request, response);
	} catch (ServletException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}


}

	//删除学生操作
void deleteStudent(HttpServletRequest request, HttpServletResponse response){
// 在这里补写代码


	StudentDao studentDao = new StudentDao();
	int id = Integer.parseInt(request.getParameter("id"));
	try {
		studentDao.deleteStudent(id);
		response.sendRedirect("StudentController");
	}catch (IOException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}


}

	//查询学生操作
void findStudent(HttpServletRequest request, HttpServletResponse response){
// 在这里补写代码


	Student student = new Student();
	String idStr = request.getParameter("id");
	if(!idStr.equals("")){
		int id = Integer.parseInt(idStr);
		student.setId(id);
	}

	String name = request.getParameter("name");
	if(!name.equals("")){
		student.setName(name);
	}

	String ageStr = request.getParameter("age");
	if(!ageStr.equals("")){
		int age = Integer.parseInt(ageStr);
		student.setAge(age);
	}

	StudentDao studentDao = new StudentDao();
	List<Student> studentList =  studentDao.search(student);
	request.setAttribute("studentList", studentList);

	try {
		request.getRequestDispatcher("view.jsp").forward(request, response);
	} catch (ServletException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}


}

	//更新学生操作
void updateStudent(HttpServletRequest request, HttpServletResponse response){
// 在这里补写代码


	StudentDao studentDao = new StudentDao();
	Student student = new Student();
	student.setId(Integer.parseInt(request.getParameter("id")));
	student.setName(request.getParameter("name"));
	student.setAge(Integer.parseInt(request.getParameter("age")));
	student.setSex(request.getParameter("sex"));
	student.setAccount(request.getParameter("account"));
	student.setPassword(request.getParameter("password"));
	TypeDao typeDao = new TypeDao();
	Type type = typeDao.getById(Integer.parseInt(request.getParameter("typeId")));
	student.setType(type);

    try {
    	studentDao.updataStudent(student);
		response.sendRedirect("StudentController");
    } catch (IOException e) {
		e.printStackTrace();
    } catch (Exception e) {
		e.printStackTrace();
	}


}

	//根据学生ID查询学生信息
void getStudentById(HttpServletRequest request, HttpServletResponse response){
// 在这里补写代码


	 StudentDao studentDao = new StudentDao();
     int id = Integer.parseInt(request.getParameter("id"));
     Student s =  new Student();
     s.setId(id);
     List<Student> studentList = studentDao.search(s);
     Student student = studentList.get(0);
	 request.setAttribute("student", student);

     try {
		request.getRequestDispatcher("update.jsp").forward(request, response);
	 } catch (ServletException e) {
		e.printStackTrace();
	 } catch (IOException e) {
		e.printStackTrace();
	 }


}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	}
}
