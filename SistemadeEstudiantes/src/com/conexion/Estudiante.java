package com.conexion;

public class Estudiante {
	private String course;
	private String branch;
	private String rollNo;
	private String name;
	private String fatherName;
	private String gender;
	
	public Estudiante(String course, String branch, String rollNo, String name, String fatherName, String gender){
		this.course=course;
		this.branch=branch;
		this.rollNo=rollNo;
		this.name=name;
		this.fatherName=fatherName;
		this.gender=gender;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
