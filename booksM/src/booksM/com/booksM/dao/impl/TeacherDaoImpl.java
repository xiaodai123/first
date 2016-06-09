package booksM.com.booksM.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import booksM.com.booksM.common.DB;
import booksM.com.booksM.dao.TeacherDao;
import booksM.com.booksM.pojo.Teacher;

public class TeacherDaoImpl implements TeacherDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public boolean findTeacherNameIsExist(String teacherName) {
		boolean result=false;
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) as c from teacher where teacher_name=?;");
			ps.setString(1, teacherName);
			rs=ps.executeQuery();
			if(rs.next()){
				if(rs.getInt("c")==1){
					result=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		
		return result;
	}

	@Override
	public boolean register(Teacher teacher) {
		boolean result=false;
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement("insert into teacher(teacher_name,teacher_pass) values(?,?);");
			ps.setString(1, teacher.getTeacherName());
			ps.setString(2, teacher.getTeacherPass());
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
	public boolean login(Teacher teacher) {
		boolean result=false;
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement("select count(*) as c from teacher where teacher_name=? and teacher_pass=?;");
			ps.setString(1, teacher.getTeacherName());
			ps.setString(2, teacher.getTeacherPass());
			rs=ps.executeQuery();
			if(rs.next()){
				if(rs.getInt("c")==1){
					result=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		
		return result;
	}

	@Override
	public Teacher getTeacherByName(String teacherName) {
		Teacher t = null;
		String sql = "select * from teacher where teacher_name=?;";
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, teacherName);
			rs=ps.executeQuery();
			if(rs.next()){
				int teacherId=rs.getInt("teacher_id");
				String teacherPass=rs.getString("teacher_pass");
				t = new Teacher(teacherId, teacherName, teacherPass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return t;
	}

	@Override
	public boolean changePass(Teacher teacher) {
		boolean result=false;
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement("update teacher set teacher_pass=? where teacher_name=?;");
			ps.setString(1, teacher.getTeacherPass());
			ps.setString(2, teacher.getTeacherName());
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

}
