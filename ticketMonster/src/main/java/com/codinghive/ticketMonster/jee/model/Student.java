package com.codinghive.ticketMonster.jee.model;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Student.getAll", query = "SELECT e FROM Student e") })
public class Student implements Serializable {

	@Id
    @Column
    private int studentId;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private int yearLevel;
    
    @Column(precision = 4, scale = 2)
    private BigDecimal grade;
    
    @Temporal(TemporalType.DATE)
    private java.util.Date startDate;
    
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public BigDecimal getGrade() {
		return grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public Student(int studentId, String firstname, String lastname, int yearLevel) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearLevel = yearLevel;
    }

	public Student(int studentId, String firstname, String lastname, int yearLevel,
			BigDecimal grade, java.util.Date startDate) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearLevel = yearLevel;
        this.grade = grade;
        this.startDate = startDate;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\''
                + ", yearLevel=" + yearLevel + '}';
    }
    
    
    
    
    
    
	//	
	// @GeneratedValue(strategy=GenerationType.SEQUENCE)
    //
	//	@TableGenerator(name = "idGenerator", 
	//	    table = "ID_GEN", 
	//	    pkColumnName = "SEQ_NAME",
	//	    valueColumnName = "SEQ_CNT", 
	//	    pkColumnValue = "CUST_SEQ",
	//        allocationSize = 10)
	//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idGenerator")
	//	
	//	@SequenceGenerator(name = "idGenerator", 
	//    sequenceName = "SEQ_ORDER", 
	//    initialValue = 1, 
	//    allocationSize = 1)
	//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idGenerator")
	//	
	    
    // ONE to ONE
    
    // One-to-one association that maps a foreign key column
    
	//    @OneToOne(optional=false, cascade = CascadeType.PERSIST)
	//    @JoinColumn(
	//        name="ACC_ID", unique=true, nullable=false, updatable=false )
	//    private Account account;
	//    
	//    public Account getAccount() { return account; }
	//    
	//    public void setAccount(Account account) {
	//        this.account = account;
	//    }
    
    // One-to-one association that assumes both the source and target share the same primary key values. 
    
    // @OneToOne @PrimaryKeyJoinColumn
    // Account account;
    
    // ONE TO MANY
    
//    @OneToMany(cascade=CascadeType.ALL, mappedBy="student")
//    @Expose
//    private List<Project> projectList;
//
//	public List<Project> getProjectList() {
//		return projectList;
//	}
//
//	public void setProjectList(List<Project> projectList) {
//		this.projectList = projectList;
//	}
    
    // MANY TO MANY
	
//	    @ManyToMany(cascade=CascadeType.ALL)
//	    @JoinTable(name="STUDENT_COURSE")
//	    @Expose
//	    private List<Course> courseList;
//	
//		public List<Course> getCourseList() {
//			return courseList;
//		}
//	
//		public void setCourseList(List<Course> courseList) {
//			this.courseList = courseList;
//		}

	
    
}
