package booksM.com.booksM.dao;

import booksM.com.booksM.pojo.Teacher;

public interface TeacherDao {

	public boolean findTeacherNameIsExist(String teacherName);
	public boolean register(Teacher teacher);
	public boolean login(Teacher teacher);
	public Teacher getTeacherByName(String teacherName);
	public boolean changePass(Teacher teacher);
	
}
