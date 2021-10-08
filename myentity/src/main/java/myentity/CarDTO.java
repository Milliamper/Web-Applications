package myentity;

//Folyamatok között közvetít adatokat. Lényege az, hogy a webszolgáltatások által végzett adatközvetítés drága. 
//Mivel ez a költség nagyrészt a szerver-kliens kapcsolatból adódnak, 
//érdemes a hívások számát csökkenteni adatátviteli objektumok beiktatásával. 
//Ez összegyűjti több hívás adatait, és egyben küldi el a szervernek.

public class CarDTO {

	private Long id;
	private String brand;
	private String type;
	private int registered;
	private double cylinderCapacity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRegistered() {
		return registered;
	}

	public void setRegistered(int registered) {
		this.registered = registered;
	}

	public double getCylinderCapacity() {
		return cylinderCapacity;
	}

	public void setCylinderCapacity(double cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}

}
