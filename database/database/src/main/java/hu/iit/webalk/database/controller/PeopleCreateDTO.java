package hu.iit.webalk.database.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import hu.iit.webalk.database.repository.People;

public class PeopleCreateDTO {

	private Long id;
	@NotEmpty
	private String name;
	@Size(min = 18)
	private int age;
	
	public PeopleCreateDTO() {
		
	}
	
	public PeopleCreateDTO(People people) {
		this.age = people.getAge();
		this.name = people.getName();
	}
	
	public PeopleCreateDTO(People people) {
		this.id = people.getId();
		this.name = people.getName();
		this.age = people.getAge();
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
	
	public People toPeople() {
		return new People(null, age, name);
	}

}
