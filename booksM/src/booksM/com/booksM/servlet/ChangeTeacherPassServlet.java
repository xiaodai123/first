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

public class ChangeTeacherPassServlet extends HttpServlet {

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

		TeacherService teacherService=new TeacherServiceImpl();
		response.setContentType("text/xml");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setCharacterEncoding("utf-8");
		String teacherName=request.getParameter("teacherName");
		String str = "修改失败";
		if(teacherName!=null&&!"".equals(teacherName)){
			teacherName=new String(teacherName.getBytes("ISO-8859-1"),"utf-8");
			String teacherPass=request.getParameter("teacherPass");
			Teacher t = new Teacher(0, teacherName, teacherPass);
			if(teacherService.changePass(t)){
				str="修改成功";
			}
		}
		pw.write(str);
		pw.flush();
		pw.close();
	}

}
