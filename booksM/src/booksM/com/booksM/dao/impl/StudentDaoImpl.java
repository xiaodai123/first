package booksM.com.booksM.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import booksM.com.booksM.common.DB;
import booksM.com.booksM.dao.StudentDao;
import booksM.com.booksM.pojo.Student;

public class StudentDaoImpl implements StudentDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public boolean addStudent(Student student) {
		boolean result = false;
		String sql = "insert into student(student_name,student_code,student_class) values(?,?,?);";
		conn = DB.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getStudentCode());
			ps.setString(3, student.getStudentClass());
			if(ps.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		
		return result;
	}

	@Override
	public boolean delStudent(Student student) {
		boolean result = false;
		String sql = "delete from student where student_id=?;";
		conn = DB.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, student.getStudentId());
			if(ps.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		
		return result;
	}

	@Override
	public boolean upStudent(Student student) {
		boolean result = false;
		String sql = "update student set student_name=?,student_code=?,student_class=? where student_id=?;";
		conn = DB.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getStudentCode());
			ps.setString(3, student.getStudentClass());
			ps.setInt(4, student.getStudentId());
			if(ps.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		
		return result;
	}

	@Override
	public Student getStudentById(int studentId) {
		Student student = null;
		String sql = "select * from student where student_id=?;";
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, studentId);
			rs=ps.executeQuery();
			if(rs.next()){
				String studentName=rs.getString("student_name");
				String studentCode=rs.getString("student_code");
				String studentClass=rs.getString("student_class");
				int bookNum=rs.getInt("book_num");
				student=new Student(studentId, studentName, studentCode, studentClass, bookNum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return student;
	}

	@Override
	public List<Student> getStudentByPageFor(Student student, int pageSize,
			int pageNow) {
		List<Student> students=new ArrayList<>();
		String sql = "select * from student where 1=1";
		List<String> paraList = new ArrayList<>();
		if(student!=null){
			String studentName=student.getStudentName().trim();
			if(studentName!=null&&!"".equals(studentName)){
				sql+=" and student_name like ?";
				paraList.add("%"+studentName+"%");
			}
			String studentCode=student.getStudentCode().trim();
			if(studentCode!=null&&!"".equals(studentCode)){
				sql+=" and student_code=?";
				paraList.add(studentCode);
			}
			String studentClass=student.getStudentClass().trim();
			if(studentClass!=null&&!"".equals(studentClass)){
				sql+=" and student_class like ?";
				paraList.add("%"+studentClass+"%");
			}
			sql+=" limit "+(pageNow-1)*pageSize+","+pageSize+";";
			conn=DB.getConnection();
			try {
				ps=conn.prepareStatement(sql);
				Object[] paras = paraList.toArray();
				if(paras!=null||paras.length!=0){
					for(int i=0;i<paras.length;i++){
						ps.setString(i+1, paras[i].toString());
					}
				}
				rs=ps.executeQuery();
				while(rs.next()){
					int studentId1=rs.getInt("student_id");
					String studentName1=rs.getString("student_name");
					String studentCode1=rs.getString("student_code");
					String studentClass1=rs.getString("student_class");
					int bookNum1=rs.getInt("book_num");
					Student student1=new Student(studentId1, studentName1, studentCode1, studentClass1, bookNum1);
					students.add(student1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DB.close(conn, ps, rs);
			}
		}
		
		return students;
	}

	@Override
	public int getStudentByPageForCount(Student student) {
		int count = 0;
		String sql = "select count(1) as c from student where 1=1";
		List<String> paraList = new ArrayList<>();
		if(student!=null){
			String studentName=student.getStudentName().trim();
			if(studentName!=null&&!"".equals(studentName)){
				sql+=" and student_name like ?";
				paraList.add("%"+studentName+"%");
			}
			String studentCode=student.getStudentCode().trim();
			if(studentCode!=null&&!"".equals(studentCode)){
				sql+=" and student_code=?";
				paraList.add(studentCode);
			}
			String studentClass=student.getStudentClass().trim();
			if(studentClass!=null&&!"".equals(studentClass)){
				sql+=" and student_class like ?";
				paraList.add("%"+studentClass+"%");
			}
			sql+=";";
			conn=DB.getConnection();
			try {
				ps=conn.prepareStatement(sql);
				Object[] paras = paraList.toArray();
				if(paras!=null||paras.length!=0){
					for(int i=0;i<paras.length;i++){
						ps.setString(i+1, paras[i].toString());
					}
				}
				rs=ps.executeQuery();
				if(rs.next()){
					count=rs.getInt("c");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DB.close(conn, ps, rs);
			}
		}
		return count;
	}

	@Override
	public boolean upBookNum(int studentId,String flag) {
		boolean result=false;
		
		String sql=null;
		if("add".equals(flag)){
			sql="update student set book_num=book_num+1 where student_id=?;";
		}
		if("sub".equals(flag)){
			sql="update student set book_num=book_num-1 where student_id=?;";
		}
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, studentId);
			if(ps.executeUpdate()==1){
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return result;
	}

	@Override
	public Student getStudentByCode(String studentCode) {
		Student student = null;
		String sql = "select * from student where student_code=?;";
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, studentCode);
			rs=ps.executeQuery();
			if(rs.next()){
				String studentName=rs.getString("student_name");
				int studentId=rs.getInt("student_id");
				String studentClass=rs.getString("student_class");
				int bookNum=rs.getInt("book_num");
				student=new Student(studentId, studentName, studentCode, studentClass, bookNum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return student;
	}

	@Override
	public int getStudentIdById(int bookId) {
		int studentId = 0;
		String sql = "select student_id from record where book_id=?;";
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bookId);
			rs=ps.executeQuery();
			if(rs.next()){
				studentId=rs.getInt("student_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		
		return studentId;
	}

}
