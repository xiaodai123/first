package booksM.com.booksM.dao;

import java.util.List;

import booksM.com.booksM.pojo.Student;

public interface StudentDao {

	public boolean addStudent(Student student);
	public boolean delStudent(Student student);
	public boolean upStudent(Student student);
	public Student getStudentById(int studentId);
	public Student getStudentByCode(String studentCode);
	public int getStudentIdById(int bookId);
	public List<Student> getStudentByPageFor(Student student,int pageSize,int pageNow);
	public int getStudentByPageForCount(Student student);
	public boolean upBookNum(int studentId,String flag);
}
