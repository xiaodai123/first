package booksM.com.booksM.pojo;

public class Teacher {

	private int teacherId;
	private String teacherName;
	private String teacherPass;
	public Teacher() {
		super();
	}
	public Teacher(int teacherId, String teacherName, String teacherPass) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherPass = teacherPass;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherPass() {
		return teacherPass;
	}
	public void setTeacherPass(String teacherPass) {
		this.teacherPass = teacherPass;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName="
				+ teacherName + ", teacherPass=" + teacherPass + "]";
	}
	
	

}
