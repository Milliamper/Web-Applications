package hu.iit.webalk.database.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class People {

	@Id
	@GeneratedValue // az így megjelölt elemeknek ő adja majd az értéket
	private Long id;

	private String name;

	private int age;

	public People(People people) {
		// TODO Auto-generated constructor stub
	}
	
	public People() {
		
	}
	
	public People(Long id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
