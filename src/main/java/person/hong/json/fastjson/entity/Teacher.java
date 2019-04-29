package person.hong.json.fastjson.entity;

import java.util.List;

public class Teacher {

	private String teacherName;
	private String teacherAge;
	private List<Student> students;
	private Course course;
	public Teacher() {
		super();
	}
	public Teacher(String teacherName, String teacherAge, List<Student> students, Course course) {
		super();
		this.teacherName = teacherName;
		this.teacherAge = teacherAge;
		this.students = students;
		this.course = course;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherAge() {
		return teacherAge;
	}
	public void setTeacherAge(String teacherAge) {
		this.teacherAge = teacherAge;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Teacher [teacherName=" + teacherName + ", teacherAge=" + teacherAge + ", students=" + students
				+ ", course=" + course + "]";
	}

	
}
