package booksM.com.booksM.pojo;

import java.util.Date;

public class Record {

	private int recordId;
	private int studentId;
	private int bookId;
	private Date recordBorrowDate;
	private Date recordReturnDate;
	
	
	private Student student;
	private Book book;
	public Record() {
		super();
	}
	public Record(int recordId, int studentId, int bookId,
			Date recordBorrowDate, Date recordReturnDate) {
		super();
		this.recordId = recordId;
		this.studentId = studentId;
		this.bookId = bookId;
		this.recordBorrowDate = recordBorrowDate;
		this.recordReturnDate = recordReturnDate;
	}
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getRecordBorrowDate() {
		return recordBorrowDate;
	}
	public void setRecordBorrowDate(Date recordBorrowDate) {
		this.recordBorrowDate = recordBorrowDate;
	}
	public Date getRecordReturnDate() {
		return recordReturnDate;
	}
	public void setRecordReturnDate(Date recordReturnDate) {
		this.recordReturnDate = recordReturnDate;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Record [recordId=" + recordId + ", studentId=" + studentId
				+ ", bookId=" + bookId + ", recordBorrowDate="
				+ recordBorrowDate + ", recordReturnDate=" + recordReturnDate
				+ "]";
	}
	

}
