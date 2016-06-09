package booksM.com.booksM.pojo;

public class Book {

	private int bookId;
	private String bookIsbn;
	private String bookName;
	private String bookAuthor;
	private String bookPublish;
	private String bookMoney;
	private boolean bookStatus;
	public Book() {
		super();
	}
	public Book(int bookId, String bookIsbn, String bookName,
			String bookAuthor, String bookPublish, String bookMoney,
			boolean bookStatus) {
		super();
		this.bookId = bookId;
		this.bookIsbn = bookIsbn;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublish = bookPublish;
		this.bookMoney = bookMoney;
		this.bookStatus = bookStatus;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublish() {
		return bookPublish;
	}
	public void setBookPublish(String bookPublish) {
		this.bookPublish = bookPublish;
	}
	public String getBookMoney() {
		return bookMoney;
	}
	public void setBookMoney(String bookMoney) {
		this.bookMoney = bookMoney;
	}
	public boolean getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(boolean bookStatus) {
		this.bookStatus = bookStatus;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookIsbn=" + bookIsbn
				+ ", bookName=" + bookName + ", bookAuthor=" + bookAuthor
				+ ", bookPublish=" + bookPublish + ", bookMoney=" + bookMoney
				+ ", bookStatus=" + bookStatus + "]";
	}
	

}
