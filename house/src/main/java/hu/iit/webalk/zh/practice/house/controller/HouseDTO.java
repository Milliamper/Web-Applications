package hu.iit.webalk.zh.practice.house.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import hu.iit.webalk.zh.practice.house.repository.House;

public class HouseDTO {

	Long id;
	@NotBlank
	String color;
	@Min(10)
	Integer floorAreaInSquareMeter;
	Boolean passiveHouse;

	public House toHouse() {
		return new House(id, color, 0, false);
	}
	
	public HouseDTO() {
		
	}

	public HouseDTO(House house) {
		super();
		this.id = house.getId();
		this.color = house.getColor();
		this.floorAreaInSquareMeter = house.getFloorAreaInSquareMeter();
		this.passiveHouse = house.isPassiveHouse();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getFloorAreaInSquareMeter() {
		return floorAreaInSquareMeter;
	}

	public void setFloorAreaInSquareMeter(Integer floorAreaInSquareMeter) {
		this.floorAreaInSquareMeter = floorAreaInSquareMeter;
	}

	public Boolean getPassiveHouse() {
		return passiveHouse;
	}

	public void setPassiveHouse(Boolean passiveHouse) {
		this.passiveHouse = passiveHouse;
	}

}
