package booksM.com.booksM.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booksM.com.booksM.pojo.Book;
import booksM.com.booksM.service.BookService;
import booksM.com.booksM.service.RecordService;
import booksM.com.booksM.service.TeacherService;
import booksM.com.booksM.service.impl.BookServiceImpl;
import booksM.com.booksM.service.impl.RecordServiceImpl;
import booksM.com.booksM.service.impl.TeacherServiceImpl;

public class CheckBookIsbnServlet extends HttpServlet {

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
		RecordService recordService =new RecordServiceImpl();
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
		String str="ok";
		Book book = bookService.getBookByIsbn(bookIsbn);
		if(book==null){
			pw.write("��Ų����ڣ�");
			pw.flush();
			pw.close();
			return;
		}
		String flag=request.getParameter("flag");
		if("borrow".equals(flag)){
			if(book.getBookStatus()){
				str="�����ѽ��!!!";
			}
			
		}
		if("return".equals(flag)){
			if(!book.getBookStatus()){
				str="����δ���!!!";
			}else if(recordService.isOutDate(book.getBookId(), new Date())){
				str="������ĳ��ڣ�����30Ԫ!!!";
			}
		}
		pw.write(str);
		pw.flush();
		pw.close();
		System.out.println();
	}

}


//��������ǿ�����һ�飺1ժҪ������+������ϵͳʵ������Щ���ܣ��������µ����ݣ�,2�ܽᣨ�ܽ����µ����ݣ�ϵͳ���ڵĲ���ȣ���Ҫд���ǵĸ��ܣ�����������3��ʽ����������4Ŀ¼��������ϸ��һ�����ǵ�Ŀ¼������������Ҫ��Ŀ¼�ǲ���һ���ģ���Ϊ���Զ����ɣ���Щͬѧ�������⣩��5ͼ�ͱ��˵�����磺ͼ2-1xxx��ͼ���棩����3.1xxxx�������棩
