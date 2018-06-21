package com.codinghive.ticketMonster.jee.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column
    private int accountId;

    @Column
    private String email;

    @Column
    private String websiteURL;
    
    @JoinColumn
    @OneToOne(optional=false, mappedBy="account")
    private Student student;
    
    public Student getStudent() { return student; }
    
	public void setStudent(Student student) {
		this.student = student;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsiteURL() {
		return websiteURL;
	}

	public void setWebsiteURL(String websiteURL) {
		this.websiteURL = websiteURL;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", email=" + email + ", websiteURL=" + websiteURL + "]";
	}
	
	public Account() {
	}

	public Account(String email, String websiteURL, Student student) {
		super();
		this.email = email;
		this.websiteURL = websiteURL;
		this.student = student;
	}

}
