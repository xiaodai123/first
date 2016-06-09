package booksM.com.booksM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booksM.com.booksM.common.Constant;
import booksM.com.booksM.pojo.Book;
import booksM.com.booksM.pojo.Record;
import booksM.com.booksM.pojo.Student;
import booksM.com.booksM.service.BookService;
import booksM.com.booksM.service.RecordService;
import booksM.com.booksM.service.StudentService;
import booksM.com.booksM.service.impl.BookServiceImpl;
import booksM.com.booksM.service.impl.RecordServiceImpl;
import booksM.com.booksM.service.impl.StudentServiceImpl;

public class ReturnBookServlet extends HttpServlet {

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

		BookService bookService=new BookServiceImpl();
		StudentService studentService=new StudentServiceImpl();
		RecordService recordService = new RecordServiceImpl();
		response.setContentType("text/xml");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setCharacterEncoding("utf-8");
		String bookIsbn=request.getParameter("bookIsbn");
		String str="归还失败！！！";
		Book book = bookService.getBookByIsbn(bookIsbn);
		Record record = new Record();
		record.setBookId(book.getBookId());
		record.setRecordReturnDate(new Date());
		boolean a = recordService.returnBook(record);
		boolean b = bookService.upBookStatus(book.getBookId(), false);
		boolean c = studentService.upBookNum(studentService.getStudentIdById(book.getBookId()), "sub");
		if(a&&b&&c){
			
			str="归还成功！！！";
		}
		
		pw.write(str);
		pw.flush();
		pw.close();
	}

}
