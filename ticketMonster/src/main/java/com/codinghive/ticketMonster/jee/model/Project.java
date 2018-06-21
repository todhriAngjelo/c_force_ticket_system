package com.codinghive.ticketMonster.jee.model;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column
    @Expose
    private int id;

    @Column
    @Expose
    private String name;

    @Column
    @Expose
    private String programmingLanguage;

    @Column
    @Expose
    private boolean complete;
    
    @ManyToOne
    @JoinColumn(name="STUDENTID")
    private Student student;
    
    public Student getStudent() { return student; }
    
	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", programmingLanguage=" + programmingLanguage + ", complete="
				+ complete + "]";
	}
	

	public Project(String name, String programmingLanguage, boolean complete, Student student) {
		super();
		this.name = name;
		this.programmingLanguage = programmingLanguage;
		this.complete = complete;
		this.student = student;
	}
	
	public Project(String name, String programmingLanguage, boolean complete) {
		super();
		this.name = name;
		this.programmingLanguage = programmingLanguage;
		this.complete = complete;
	}

	public Project() {
		
	}

}
