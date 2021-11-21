package hu.iit.webalk.database.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import hu.iit.webalk.database.service.People;

public class PeopleDTO {

	private Long id;

	@NotEmpty
	private String name;

	@Min(18)
	private int age;

	public PeopleDTO() {

	}

	public PeopleDTO(People people) {
		this.id = people.getId();
		this.name = people.getName();
		this.age = people.getAge();
	}

	public People toPeople() {
		return new People(id, age, name);
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
