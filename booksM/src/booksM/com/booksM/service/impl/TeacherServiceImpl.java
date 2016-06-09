package booksM.com.booksM.service.impl;

import booksM.com.booksM.dao.TeacherDao;
import booksM.com.booksM.dao.impl.TeacherDaoImpl;
import booksM.com.booksM.pojo.Teacher;
import booksM.com.booksM.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	private TeacherDao teacherDao;
	public TeacherServiceImpl(){
		teacherDao=new TeacherDaoImpl();
	}
	@Override
	public boolean findTeacherNameIsExist(String teacherName) {
		return teacherDao.findTeacherNameIsExist(teacherName);
	}

	@Override
	public boolean register(Teacher teacher) {
		return teacherDao.register(teacher);
	}

	@Override
	public boolean login(Teacher teacher) {
		return teacherDao.login(teacher);
	}
	@Override
	public Teacher getTeacherByName(String teacherName) {
		return teacherDao.getTeacherByName(teacherName);
	}
	@Override
	public boolean changePass(Teacher teacher) {
		return teacherDao.changePass(teacher);
	}

}
