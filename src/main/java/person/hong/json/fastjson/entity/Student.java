package person.hong.json.fastjson.entity;

public class Student {

	private String studentName;
	private String studentAge;
	public Student() {
		super();
	}
	public Student(String studentName, String studentAge) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentAge=" + studentAge + "]";
	}

	
}
