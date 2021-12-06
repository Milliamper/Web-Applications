package hu.iit.webalk.zh.practice.house.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class House {

	@Id
	@GeneratedValue
	Long id;
	String color;
	int floorAreaInSquareMeter;
	boolean passiveHouse;
	
	public House toEntity() {
		return new House(id, color, floorAreaInSquareMeter, passiveHouse);
	}
	
	public House() {
		
	}
	
	public House(House house) {
		this.id = house.getId();
		this.color = house.getColor();
		this.floorAreaInSquareMeter = house.getFloorAreaInSquareMeter();
		this.passiveHouse = house.isPassiveHouse();
	}

	public House(Long id, String color, int floorAreaInSquareMeter, boolean passiveHouse) {
		super();
		this.id = id;
		this.color = color;
		this.floorAreaInSquareMeter = floorAreaInSquareMeter;
		this.passiveHouse = passiveHouse;
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

	public int getFloorAreaInSquareMeter() {
		return floorAreaInSquareMeter;
	}

	public void setFloorAreaInSquareMeter(int floorAreaInSquareMeter) {
		this.floorAreaInSquareMeter = floorAreaInSquareMeter;
	}

	public boolean isPassiveHouse() {
		return passiveHouse;
	}

	public void setPassiveHouse(boolean passiveHouse) {
		this.passiveHouse = passiveHouse;
	}

}
