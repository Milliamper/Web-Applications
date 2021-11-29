package hu.iit.webalk.zh.practice.student.repository;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	private String NeptunID;
	private boolean isActiveStatus;
	private int balance;
	private LocalDate beginningOfLegalRelationship;
	

	public Student(Long id, String neptunID, boolean isActiveStatus, int balance,
			LocalDate beginningOfLegalRelationship) {
		super();
		this.id = id;
		this.NeptunID = neptunID;
		this.isActiveStatus = isActiveStatus;
		this.balance = balance;
		this.beginningOfLegalRelationship = beginningOfLegalRelationship;
	}

	public Student(Student student) {
		this.id = student.getId();
		this.NeptunID = student.getNeptunID();
		this.isActiveStatus = student.isActiveStatus;
		this.balance = student.getBalance();
		this.beginningOfLegalRelationship = student.getBeginningOfLegalRelationship();
	}

	public Student toEntity() {
		return new Student(id, NeptunID, isActiveStatus, balance, beginningOfLegalRelationship);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNeptunID() {
		return NeptunID;
	}

	public void setNeptunID(String neptunID) {
		NeptunID = neptunID;
	}

	public boolean isActiveStatus() {
		return isActiveStatus;
	}

	public void setActiveStatus(boolean isActiveStatus) {
		this.isActiveStatus = isActiveStatus;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public LocalDate getBeginningOfLegalRelationship() {
		return beginningOfLegalRelationship;
	}

	public void setBeginningOfLegalRelationship(LocalDate beginningOfLegalRelationship) {
		this.beginningOfLegalRelationship = beginningOfLegalRelationship;
	}

}
