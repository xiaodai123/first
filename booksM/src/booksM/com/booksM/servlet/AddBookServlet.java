package booksM.com.booksM.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booksM.com.booksM.pojo.Book;
import booksM.com.booksM.service.BookService;
import booksM.com.booksM.service.impl.BookServiceImpl;

public class AddBookServlet extends HttpServlet {

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
		BookService bookService = new BookServiceImpl();
		String bookIsbn = (String)request.getParameter("bookIsbn");
		String bookName = (String)request.getParameter("bookName");
		String bookAuthor = (String)request.getParameter("bookAuthor");
		String bookPublish = (String)request.getParameter("bookPublish");
		String bookMoney = (String)request.getParameter("bookMoney");
		if(bookName!=null&&!"".equals(bookName)){
			bookName = new String(bookName.getBytes("ISO-8859-1"),"utf-8");
		}
		if(bookAuthor!=null&&!"".equals(bookAuthor)){
			bookAuthor = new String(bookAuthor.getBytes("ISO-8859-1"),"utf-8");
		}
		if(bookPublish!=null&&!"".equals(bookPublish)){
			bookPublish = new String(bookPublish.getBytes("ISO-8859-1"),"utf-8");
		}
		if(up==null||"".equals(up)){
			Book book = new Book(0, bookIsbn, bookName, bookAuthor, bookPublish, bookMoney, false);
			String msg = "录入失败！";
			if(bookService.addBook(book)){
				msg="录入成功！";
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/view/addBook.jsp").forward(request, response);
			return;
		}
		if("up".equals(up)){
			int bookId = Integer.parseInt((String)request.getParameter("bookId"));
			Book book = new Book(bookId, bookIsbn, bookName, bookAuthor, bookPublish, bookMoney, false);
			String msg = "修改失败！";
			if(bookService.upBook(book)){
				msg="修改成功！";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("flag", "one");
			request.setAttribute("so", "so");
			request.setAttribute("bookId", bookId);
			request.getRequestDispatcher("BookServlet").forward(request, response);
			return;
		}
	}

}
