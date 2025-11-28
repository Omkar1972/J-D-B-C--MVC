package model;

public class Student {
	
	private int s_id;
	private String s_name;

	
//	Getter and Setter...
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	
	
//	Constructor using Fields.....
	public Student(int s_id, String s_name) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
	}
	
//	Constructor using Super...
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	To String Method....
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + "]";
	}
	
	
	

}
