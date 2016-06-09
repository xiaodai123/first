package booksM.com.booksM.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booksM.com.booksM.pojo.Student;
import booksM.com.booksM.service.StudentService;
import booksM.com.booksM.service.impl.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet {

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

		String up = (String)request.getParameter("up");
		StudentService studentService = new StudentServiceImpl();
		String studentCode = (String)request.getParameter("studentCode");
		String studentName = (String)request.getParameter("studentName");
		String studentClass = (String)request.getParameter("studentClass");
		if(studentName!=null&&!"".equals(studentName)){
			studentName = new String(studentName.getBytes("ISO-8859-1"),"utf-8");
		}
		if(studentClass!=null&&!"".equals(studentClass)){
			studentClass = new String(studentClass.getBytes("ISO-8859-1"),"utf-8");
		}
		if(up==null||"".equals(up)){
			Student student = new Student(0, studentName, studentCode, studentClass, 0);
			String msg = "录入失败！";
			if(studentService.addStudent(student)){
				msg="录入成功！";
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/view/addStudent.jsp").forward(request, response);
			return;
		}
		if("up".equals(up)){
			int studentId = Integer.parseInt((String)request.getParameter("studentId"));
			Student student = new Student(studentId, studentName, studentCode, studentClass, 0);
			String msg = "修改失败！";
			if(studentService.upStudent(student)){
				msg="修改成功！";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("flag", "one");
			request.setAttribute("so", "so");
			request.setAttribute("studentId", studentId);
			request.getRequestDispatcher("StudentServlet").forward(request, response);
			return;
		}
		
		
	}

}
