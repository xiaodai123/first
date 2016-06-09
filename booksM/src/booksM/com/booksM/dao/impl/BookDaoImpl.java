package booksM.com.booksM.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import booksM.com.booksM.common.DB;
import booksM.com.booksM.dao.BookDao;
import booksM.com.booksM.pojo.Book;

public class BookDaoImpl implements BookDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public boolean addBook(Book book) {
		boolean result=false;
		String sql = "insert into book(book_isbn,book_name,book_author,book_publish,book_money) values(?,?,?,?,?);";
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, book.getBookIsbn());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getBookAuthor());
			ps.setString(4, book.getBookPublish());
			ps.setString(5, book.getBookMoney());
			if(ps.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return result;
	}

	@Override
	public boolean delBook(Book book) {
		boolean result=false;
		String sql = "delete from book where book_id=?;";
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, book.getBookId());
			if(ps.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return result;
	}

	@Override
	public boolean upBook(Book book) {
		boolean result=false;
		String sql = "update book set book_isbn=?,book_name=?,book_author=?,book_publish=?,book_money=? where book_id=?;";
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, book.getBookIsbn());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getBookAuthor());
			ps.setString(4, book.getBookPublish());
			ps.setString(5, book.getBookMoney());
			ps.setInt(6, book.getBookId());
			if(ps.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return result;
	}

	@Override
	public Book getBookById(int bookId) {
		Book book=null;
		String sql="select * from book where book_id=?";
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bookId);
			rs=ps.executeQuery();
			if(rs.next()){
				String bookIsbn = rs.getString("book_isbn");
				String bookName = rs.getString("book_name");
				String bookAuthor = rs.getString("book_author");
				String bookPublish = rs.getString("book_publish");
				String bookMoney = rs.getString("book_money");
				boolean bookStatus = rs.getBoolean("book_status");
				book = new Book(bookId, bookIsbn, bookName, bookAuthor, bookPublish, bookMoney, bookStatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return book;
	}

	@Override
	public List<Book> getBookByPageFor(Book book, int pageSize, int pageNow) {
		List<Book> books=new ArrayList<>();
		String sql = "select * from book where 1=1";
		List<String> paraList = new ArrayList<>();
		if(book!=null){
			String bookIsbn=book.getBookIsbn().trim();
			if(bookIsbn!=null&&!"".equals(bookIsbn)){
				sql+=" and book_isbn like ?";
				paraList.add("%"+bookIsbn+"%");
			}
			String bookName=book.getBookName().trim();
			if(bookName!=null&&!"".equals(bookName)){
				sql+=" and book_name like ?";
				paraList.add("%"+bookName+"%");
			}
			String bookAuthor=book.getBookAuthor().trim();
			if(bookAuthor!=null&&!"".equals(bookAuthor)){
				sql+=" and book_author like ?";
				paraList.add("%"+bookAuthor+"%");
			}
			String bookPublish=book.getBookPublish().trim();
			if(bookPublish!=null&&!"".equals(bookPublish)){
				sql+=" and book_publish like ?";
				paraList.add("%"+bookPublish+"%");
			}
			sql+=" limit "+(pageNow-1)*pageSize+","+pageSize+";";
			conn=DB.getConnection();
			try {
				ps=conn.prepareStatement(sql);
				Object[] paras = paraList.toArray();
				if(paras!=null||paras.length!=0){
					for(int i=0;i<paras.length;i++){
						ps.setString(i+1, paras[i].toString());
					}
				}
				rs=ps.executeQuery();
				while(rs.next()){
					int bookId1=rs.getInt("book_id");
					String bookIsbn1 = rs.getString("book_isbn");
					String bookName1 = rs.getString("book_name");
					String bookAuthor1 = rs.getString("book_author");
					String bookPublish1 = rs.getString("book_publish");
					String bookMoney1 = rs.getString("book_money");
					boolean bookStatus1 = rs.getBoolean("book_status");
					Book b = new Book(bookId1, bookIsbn1, bookName1, bookAuthor1, bookPublish1, bookMoney1, bookStatus1);
					books.add(b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DB.close(conn, ps, rs);
			}
		}
		
		return books;
	}

	@Override
	public int getBookByPageForCount(Book book) {
		int count = 0;
		String sql = "select count(1) as c from book where 1=1";
		List<String> paraList = new ArrayList<>();
		if(book!=null){
			String bookIsbn=book.getBookIsbn().trim();
			if(bookIsbn!=null&&!"".equals(bookIsbn)){
				sql+=" and book_isbn like ?";
				paraList.add("%"+bookIsbn+"%");
			}
			String bookName=book.getBookName().trim();
			if(bookName!=null&&!"".equals(bookName)){
				sql+=" and book_name=?";
				paraList.add("%"+bookName+"%");
			}
			String bookAuthor=book.getBookAuthor().trim();
			if(bookAuthor!=null&&!"".equals(bookAuthor)){
				sql+=" and book_author like ?";
				paraList.add("%"+bookAuthor+"%");
			}
			String bookPublish=book.getBookPublish().trim();
			if(bookPublish!=null&&!"".equals(bookPublish)){
				sql+=" and book_publish like ?";
				paraList.add("%"+bookPublish+"%");
			}
			sql+=";";
			conn=DB.getConnection();
			try {
				ps=conn.prepareStatement(sql);
				Object[] paras = paraList.toArray();
				if(paras!=null||paras.length!=0){
					for(int i=0;i<paras.length;i++){
						ps.setString(i+1, paras[i].toString());
					}
				}
				rs=ps.executeQuery();
				if(rs.next()){
					count=rs.getInt("c");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DB.close(conn, ps, rs);
			}
		}
		return count;
	}

	@Override
	public boolean upBookStatus(int bookId,boolean bookStatus) {
		boolean result=false;
		String sql = "update book set book_status=? where book_id=?;";
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setBoolean(1, bookStatus);
			ps.setInt(2, bookId);
			if(ps.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return result;
	}

	@Override
	public Book getBookByIsbn(String bookIsbn) {
		Book book=null;
		String sql="select * from book where book_isbn=?";
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, bookIsbn);
			rs=ps.executeQuery();
			if(rs.next()){
				int bookId = rs.getInt("book_id");
				String bookName = rs.getString("book_name");
				String bookAuthor = rs.getString("book_author");
				String bookPublish = rs.getString("book_publish");
				String bookMoney = rs.getString("book_money");
				boolean bookStatus = rs.getBoolean("book_status");
				book = new Book(bookId, bookIsbn, bookName, bookAuthor, bookPublish, bookMoney, bookStatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return book;
	}

}
