package booksM.com.booksM.pojo;

public class Student {

	private int studentId;
	private String studentName;
	private String studentCode;
	private String studentClass;
	private int bookNum;
	public Student() {
		super();
	}
	public Student(int studentId, String studentName, String studentCode,
			String studentClass, int bookNum) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCode = studentCode;
		this.studentClass = studentClass;
		this.bookNum = bookNum;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName="
				+ studentName + ", studentCode=" + studentCode
				+ ", studentClass=" + studentClass + ", bookNum=" + bookNum
				+ "]";
	}
	
	

}
