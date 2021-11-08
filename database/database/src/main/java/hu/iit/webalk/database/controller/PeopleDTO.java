package hu.iit.webalk.database.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import hu.iit.webalk.database.service.People;

public class PeopleDTO {

	private Long id;
	@NotEmpty
	private String name;
	@Size(min = 18)
	private int age;
	
	public PeopleDTO() {
		
	}
	
	public PeopleDTO(People people) {
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

}
