package booksM.com.booksM.service.impl;

import java.util.Date;

import booksM.com.booksM.dao.RecordDao;
import booksM.com.booksM.dao.impl.RecordDaoImpl;
import booksM.com.booksM.pojo.Record;
import booksM.com.booksM.service.RecordService;

public class RecordServiceImpl implements RecordService {

	private RecordDao recordDao = null;
	public RecordServiceImpl(){
		recordDao = new RecordDaoImpl();
	}
	@Override
	public boolean borrowBook(Record record) {
		return recordDao.borrowBook(record);
	}

	@Override
	public boolean returnBook(Record record) {
		return recordDao.returnBook(record);
	}

	@Override
	public boolean isOutDate(int bookId, Date recordReturnDate) {
		return recordDao.isOutDate(bookId, recordReturnDate);
	}

}
