package hu.iit.webalk.database.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import hu.iit.webalk.database.service.People;

public class PeopleCreateDTO {

	@NotEmpty
	private String name;
	@Min(18)
	private int age;
	
	public PeopleCreateDTO() {
		
	}
	
	public PeopleCreateDTO(People people) {
		this.name = people.getName();
		this.age = people.getAge();
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
