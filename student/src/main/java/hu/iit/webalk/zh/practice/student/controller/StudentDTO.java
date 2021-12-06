package hu.iit.webalk.zh.practice.student.controller;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import hu.iit.webalk.zh.practice.student.service.Student;

public class StudentDTO {

	private Long id;
	private String NeptunID;
	private boolean isActiveStatus;
	@NotNull
	private int balance;
	@DateTimeFormat
	private LocalDate beginningOfLegalRelationship;
	@Range(min = 1, max = 2)
	private int type; // 1: hallgato, 2: oktato

	public StudentDTO(Student student) {
		super();
		this.id = student.getId();
		this.NeptunID = student.getNeptunID();
		this.isActiveStatus = student.isActiveStatus();
		this.balance = student.getBalance();
		this.beginningOfLegalRelationship = student.getBeginningOfLegalRelationship();
		this.type = student.getType();
	}
	
	public Student toStudent() {
		return new Student(id, NeptunID, isActiveStatus, balance, beginningOfLegalRelationship, type);
	}
	
	public StudentDTO() {
		
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
