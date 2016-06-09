package booksM.com.booksM.dao;

import java.util.List;

import booksM.com.booksM.pojo.Book;

public interface BookDao {

	public boolean addBook(Book book);
	public boolean delBook(Book book);
	public boolean upBook(Book book);
	public Book getBookById(int bookId);
	public Book getBookByIsbn(String bookIsbn);
	public List<Book> getBookByPageFor(Book book,int pageSize,int pageNow);
	public int getBookByPageForCount(Book book);
	public boolean upBookStatus(int bookId,boolean bookStatus);
}
