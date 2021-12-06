package hu.iit.webalk.zh.practice.house.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import hu.iit.webalk.zh.practice.house.repository.House;

public class HouseCreateDTO {

	@NotBlank
	String color;
	@Min(10)
	Integer floorAreaInSquareMeter;
	Boolean passiveHouse;

	public House toHouse() {
		return new House(null, color, 0, false);
	}
	
	public HouseCreateDTO() {
		
	}

	public HouseCreateDTO(House house) {
		super();
		this.color = house.getColor();
		this.floorAreaInSquareMeter = house.getFloorAreaInSquareMeter();
		this.passiveHouse = house.isPassiveHouse();
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
