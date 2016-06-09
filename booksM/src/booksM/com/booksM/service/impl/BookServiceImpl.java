package booksM.com.booksM.service.impl;

import java.util.List;

import booksM.com.booksM.dao.BookDao;
import booksM.com.booksM.dao.impl.BookDaoImpl;
import booksM.com.booksM.pojo.Book;
import booksM.com.booksM.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = null;
	public BookServiceImpl(){
		bookDao = new BookDaoImpl();
	}
	@Override
	public boolean addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Override
	public boolean delBook(Book book) {
		return bookDao.delBook(book);
	}

	@Override
	public boolean upBook(Book book) {
		return bookDao.upBook(book);
	}

	@Override
	public Book getBookById(int bookId) {
		return bookDao.getBookById(bookId);
	}

	@Override
	public List<Book> getBookByPageFor(Book book, int pageSize, int pageNow) {
		return bookDao.getBookByPageFor(book, pageSize, pageNow);
	}

	@Override
	public int getBookByPageForCount(Book book) {
		return bookDao.getBookByPageForCount(book);
	}

	@Override
	public boolean upBookStatus(int bookId, boolean bookStatus) {
		return bookDao.upBookStatus(bookId, bookStatus);
	}
	@Override
	public Book getBookByIsbn(String bookIsbn) {
		return bookDao.getBookByIsbn(bookIsbn);
	}

}
