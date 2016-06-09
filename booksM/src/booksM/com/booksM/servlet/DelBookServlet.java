package booksM.com.booksM.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booksM.com.booksM.pojo.Book;
import booksM.com.booksM.service.BookService;
import booksM.com.booksM.service.impl.BookServiceImpl;

public class DelBookServlet extends HttpServlet {

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

		BookService bookService = new BookServiceImpl();
		int bookId = Integer.parseInt((String)request.getParameter("bookId"));
		Book book = new Book();
		book.setBookId(bookId);
		String msg = "É¾³ýÊ§°Ü£¡";
		if(bookService.delBook(book)){
			msg = "É¾³ý³É¹¦£¡";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("BookServlet?flag=list&sign=2").forward(request, response);
	}

}
