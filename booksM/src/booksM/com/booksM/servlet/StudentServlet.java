package booksM.com.booksM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import booksM.com.booksM.common.Constant;
import booksM.com.booksM.pojo.Student;
import booksM.com.booksM.service.StudentService;
import booksM.com.booksM.service.impl.StudentServiceImpl;

public class StudentServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String flag = (String)request.getParameter("flag");
		String up=null;
		HttpSession session = request.getSession();
		session.setAttribute("msg", "");
		StudentService studentService = new StudentServiceImpl();
		if("list".equals(flag)){
			String sign = (String)request.getParameter("sign");
			List<Student> students = new ArrayList<>();
			int number = 0;
			if(sign.equals("2")){
				Student s1=(Student)session.getAttribute("student");
				int oldPageNow=(Integer)session.getAttribute("pageNow");
				students=studentService.getStudentByPageFor(s1, Constant.PAGE_SIZE, oldPageNow);
				number=studentService.getStudentByPageForCount(s1);
				int pageNum=0;
				if(number!=0){
					if(number%Constant.PAGE_SIZE==0){
						pageNum=number/Constant.PAGE_SIZE;
					}else{
						pageNum=number/Constant.PAGE_SIZE+1;
					}
				}
				request.setAttribute("pageNow", oldPageNow);
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("students", students);
				request.setAttribute("msg", (String)request.getAttribute("msg"));
				request.getRequestDispatcher("/view/studentList.jsp").forward(request, response);
				return;
			}
			int pageNow = Integer.parseInt((String)request.getParameter("pageNow"));
			String studentCode = (String)request.getParameter("studentCode");
			String studentName = (String)request.getParameter("studentName");
			String studentClass = (String)request.getParameter("studentClass");
			if(studentName!=null&&!"".equals(studentName)){
				studentName = new String(studentName.getBytes("ISO-8859-1"),"utf-8");
			}
			if(studentClass!=null&&!"".equals(studentClass)){
				studentClass = new String(studentClass.getBytes("ISO-8859-1"),"utf-8");
			}
			Student student = new Student(0, studentName, studentCode, studentClass, 0);
			
			if(sign.equals("1")){
				session.setAttribute("student", student);
				session.setAttribute("pageNow", pageNow);
				students=studentService.getStudentByPageFor(student, Constant.PAGE_SIZE, pageNow);
				number=studentService.getStudentByPageForCount(student);
			}
			
			if(sign.equals("3")){
				Student s1=(Student)session.getAttribute("student");
				session.setAttribute("pageNow", pageNow);
				students=studentService.getStudentByPageFor(s1, Constant.PAGE_SIZE, pageNow);
				number=studentService.getStudentByPageForCount(s1);
			}
			
			int pageNum=0;
			if(number!=0){
				if(number%Constant.PAGE_SIZE==0){
					pageNum=number/Constant.PAGE_SIZE;
				}else{
					pageNum=number/Constant.PAGE_SIZE+1;
				}
			}
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("students", students);
			request.getRequestDispatcher("/view/studentList.jsp").forward(request, response);
			return;
		}
		if(flag==null||"".equals(flag)){
			flag = (String)request.getAttribute("flag");
			up = "up";
		}
		if("one".equals(flag)){
			int studentId=Integer.parseInt((String)request.getParameter("studentId"));
			Student student = studentService.getStudentById(studentId);
			request.setAttribute("student", student);
			request.setAttribute("up", "up");
			String so = null;
			if("up".equals(up)){
				studentId = (int) request.getAttribute("studentId");
				so = (String)request.getAttribute("so");
			}
			
			if("so".equals(so)){
				request.setAttribute("msg", (String)request.getAttribute("msg"));
			}
			request.getRequestDispatcher("/view/addStudent.jsp").forward(request, response);
			return;
		}
	}
	

}
