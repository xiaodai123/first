package booksM.com.booksM.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booksM.com.booksM.pojo.Teacher;
import booksM.com.booksM.service.TeacherService;
import booksM.com.booksM.service.impl.TeacherServiceImpl;

public class RegisterServlet extends HttpServlet {

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
		response.setContentType("text/xml");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String teacherName = request.getParameter("teacherName");
		if(teacherName != null && !"".equals(teacherName)){
			teacherName = new String(teacherName.getBytes("ISO-8859-1"),"utf-8");
		}
		String teacherPass = request.getParameter("teacherPass");
		Teacher teacher = new Teacher();
		teacher.setTeacherName(teacherName);
		teacher.setTeacherPass(teacherPass);
		TeacherService teacherService=new TeacherServiceImpl();
		if(teacherService.register(teacher)){
			request.getSession().setAttribute("teacher", teacherService.findTeacherNameIsExist(teacherName));
			request.getRequestDispatcher("/view/index.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "×¢²áÊ§°Ü£¬ÇëÖØÐÂ×¢²á£¡£¡£¡");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

}
