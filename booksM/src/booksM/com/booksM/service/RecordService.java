package booksM.com.booksM.service;

import java.util.Date;

import booksM.com.booksM.pojo.Record;

public interface RecordService {

	public boolean borrowBook(Record record);
	public boolean returnBook(Record record);
	public boolean isOutDate(int bookId,Date recordReturnDate);
}
