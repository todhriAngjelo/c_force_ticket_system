package com.codinghive.ticketMonster.jee.model;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column
    @Expose
    private int courseId;

    @Column
    @Expose
    private String name;

    @Column
    @Expose
    private String courseURL;
    
    @Column
    @Expose
    private String professor;
    
    @Column
    @Expose
    private int semester;
    
//    @ManyToMany(mappedBy="courseList")
    private List<Student> studentList;

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseURL() {
		return courseURL;
	}

	public void setCourseURL(String courseURL) {
		this.courseURL = courseURL;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", courseURL=" + courseURL + ", professor="
				+ professor + ", semester=" + semester + "]";
	}
	
	public Course(String name, String courseURL, String professor, int semester, Student student) {
		super();
		this.name = name;
		this.courseURL = courseURL;
		this.professor = professor;
		this.semester = semester;
	}

	public Course() {
		
	}

}
