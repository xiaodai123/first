package booksM.com.booksM.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import booksM.com.booksM.common.Constant;
import booksM.com.booksM.pojo.Book;
import booksM.com.booksM.service.BookService;
import booksM.com.booksM.service.impl.BookServiceImpl;

public class BookServlet extends HttpServlet {

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
		BookService bookService = new BookServiceImpl();
		if("list".equals(flag)){
			String sign = (String)request.getParameter("sign");
			List<Book> books = new ArrayList<>();
			int number = 0;
			if(sign.equals("2")){
				Book b1=(Book)session.getAttribute("book");
				int oldPageNow=(Integer)session.getAttribute("pageNow");
				books=bookService.getBookByPageFor(b1, Constant.PAGE_SIZE, oldPageNow);
				number=bookService.getBookByPageForCount(b1);
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
				request.setAttribute("books", books);
				request.setAttribute("msg", (String)request.getAttribute("msg"));
				request.getRequestDispatcher("/view/bookList.jsp").forward(request, response);
				return;
			}
			int pageNow = Integer.parseInt((String)request.getParameter("pageNow"));
			String bookIsbn = (String)request.getParameter("bookIsbn");
			String bookName = (String)request.getParameter("bookName");
			String bookAuthor = (String)request.getParameter("bookAuthor");
			String bookPublish = (String)request.getParameter("bookPublish");
			if(bookName!=null&&!"".equals(bookName)){
				bookName = new String(bookName.getBytes("ISO-8859-1"),"utf-8");
			}
			if(bookAuthor!=null&&!"".equals(bookAuthor)){
				bookAuthor = new String(bookAuthor.getBytes("ISO-8859-1"),"utf-8");
			}
			if(bookPublish!=null&&!"".equals(bookPublish)){
				bookPublish = new String(bookPublish.getBytes("ISO-8859-1"),"utf-8");
			}
			Book book =new Book(0, bookIsbn, bookName, bookAuthor, bookPublish, null, false);
			
			if(sign.equals("1")){
				session.setAttribute("book", book);
				session.setAttribute("pageNow", pageNow);
				books=bookService.getBookByPageFor(book, Constant.PAGE_SIZE, pageNow);
				number=bookService.getBookByPageForCount(book);
			}
			
			if(sign.equals("3")){
				Book b1=(Book)session.getAttribute("book");
				session.setAttribute("pageNow", pageNow);
				books=bookService.getBookByPageFor(b1, Constant.PAGE_SIZE, pageNow);
				number=bookService.getBookByPageForCount(b1);
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
			request.setAttribute("books", books);
			request.getRequestDispatcher("/view/bookList.jsp").forward(request, response);
			return;
		}
		if(flag==null||"".equals(flag)){
			flag = (String)request.getAttribute("flag");
			up = "up";
		}
		if("one".equals(flag)){
			int bookId=Integer.parseInt((String)request.getParameter("bookId"));
			Book book = bookService.getBookById(bookId);
			request.setAttribute("book", book);
			request.setAttribute("up", "up");
			String so = null;
			if("up".equals(up)){
				bookId = (int) request.getAttribute("bookId");
				so = (String)request.getAttribute("so");
			}
			
			if("so".equals(so)){
				request.setAttribute("msg", (String)request.getAttribute("msg"));
			}
			request.getRequestDispatcher("/view/addBook.jsp").forward(request, response);
			return;
		}
	}

}
