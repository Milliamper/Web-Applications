package hu.iit.webalk.zh.practice.student.controller;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import hu.iit.webalk.zh.practice.student.repository.Student;

public class StudentCreateDTO {

	@NotEmpty
	private String NeptunID;
	private boolean isActiveStatus;
	@Min(1)
	private int balance;
	@DateTimeFormat
	private LocalDate beginningOfLegalRelationship;

	public StudentCreateDTO(Student student) {
		this.NeptunID = student.getNeptunID();
		this.isActiveStatus = student.isActiveStatus();
		this.balance = student.getBalance();
		this.beginningOfLegalRelationship = student.getBeginningOfLegalRelationship();
	}

	public Student toEntity() {
		return new Student(null, NeptunID, isActiveStatus, balance, beginningOfLegalRelationship);
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
