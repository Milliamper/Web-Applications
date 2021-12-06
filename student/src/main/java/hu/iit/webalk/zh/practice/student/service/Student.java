package hu.iit.webalk.zh.practice.student.service;

import java.time.LocalDate;
import java.util.Optional;

//StudentServiceDTO
public class Student {

	private Long id;
	private String NeptunID;
	private boolean isActiveStatus;
	private int balance;
	private LocalDate beginningOfLegalRelationship;
	private int type; // 1: hallgato, 2: oktato

	public Student(hu.iit.webalk.zh.practice.student.repository.Student student) {
		super();
		this.id = student.getId();
		this.NeptunID = student.getNeptunID();
		this.isActiveStatus = student.isActiveStatus();
		this.balance = student.getBalance();
		this.beginningOfLegalRelationship = student.getBeginningOfLegalRelationship();
		this.type = student.getType();
	}

	public hu.iit.webalk.zh.practice.student.repository.Student toEntity() {
		return new hu.iit.webalk.zh.practice.student.repository.Student(id, NeptunID, isActiveStatus, balance,
				beginningOfLegalRelationship, type);
	}

	public Student() {

	}

	public Student(Long id, String neptunID, boolean isActiveStatus, int balance,
			LocalDate beginningOfLegalRelationship, int type) {
		super();
		this.id = id;
		NeptunID = neptunID;
		this.isActiveStatus = isActiveStatus;
		this.balance = balance;
		this.beginningOfLegalRelationship = beginningOfLegalRelationship;
		this.type = type;
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
