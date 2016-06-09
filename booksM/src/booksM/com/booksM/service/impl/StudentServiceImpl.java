package booksM.com.booksM.service.impl;

import java.util.List;

import booksM.com.booksM.dao.StudentDao;
import booksM.com.booksM.dao.impl.StudentDaoImpl;
import booksM.com.booksM.pojo.Student;
import booksM.com.booksM.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao= null;
	public StudentServiceImpl(){
		studentDao = new StudentDaoImpl();
	}
	@Override
	public boolean addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	@Override
	public boolean delStudent(Student student) {
		return studentDao.delStudent(student);
	}

	@Override
	public boolean upStudent(Student student) {
		return studentDao.upStudent(student);
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDao.getStudentById(studentId);
	}

	@Override
	public List<Student> getStudentByPageFor(Student student, int pageSize,
			int pageNow) {
		return studentDao.getStudentByPageFor(student, pageSize, pageNow);
	}

	@Override
	public int getStudentByPageForCount(Student student) {
		return studentDao.getStudentByPageForCount(student);
	}

	@Override
	public boolean upBookNum(int studentId,String flag) {
		return studentDao.upBookNum(studentId,flag);
	}
	@Override
	public Student getStudentByCode(String studentCode) {
		return studentDao.getStudentByCode(studentCode);
	}
	@Override
	public int getStudentIdById(int bookId) {
		return studentDao.getStudentIdById(bookId);
	}

}
