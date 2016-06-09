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
			pw.write("书号不存在！");
			pw.flush();
			pw.close();
			return;
		}
		String flag=request.getParameter("flag");
		if("borrow".equals(flag)){
			if(book.getBookStatus()){
				str="该书已借出!!!";
			}
			
		}
		if("return".equals(flag)){
			if(!book.getBookStatus()){
				str="该书未借出!!!";
			}else if(recordService.isOutDate(book.getBookId(), new Date())){
				str="该书借阅超期，罚款30元!!!";
			}
		}
		pw.write(str);
		pw.flush();
		pw.close();
		System.out.println();
	}

}


//论文我在强调最后一遍：1摘要（背景+你做的系统实现了哪些功能，不是文章的内容）,2总结（总结文章的内容，系统存在的不足等，不要写你们的感受！！！！）；3格式！！！！；4目录（各自仔细看一下你们的目录，看和你们想要的目录是不是一样的，因为是自动生成，有些同学的有问题）；5图和表的说明，如：图2-1xxx（图下面）；表3.1xxxx（表上面）
