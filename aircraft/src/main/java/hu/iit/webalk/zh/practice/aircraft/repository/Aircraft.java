package hu.iit.webalk.zh.practice.aircraft.repository;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aircraft {

	@Id
	@GeneratedValue
	private Long id;
	private String manufacturer;
	private String model;
	private int numberOfEngines;
	private LocalDate firstFlight;
	private boolean inService;

	public Aircraft(Long id, String manufacturer, String model, int numberOfEngines, LocalDate firstFlight,
			boolean inService) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.numberOfEngines = numberOfEngines;
		this.firstFlight = firstFlight;
		this.inService = inService;
	}
	
	public Aircraft(Aircraft aircraft) {
		super();
		this.id = aircraft.getId();
		this.manufacturer = aircraft.getManufacturer();
		this.model = aircraft.getModel();
		this.numberOfEngines = aircraft.numberOfEngines;
		this.firstFlight = aircraft.getFirstFlight();
		this.inService = aircraft.isInService();
	}

	public Aircraft() {

	}
	
	public Aircraft toEntity() {
		return new Aircraft(id, manufacturer, model, numberOfEngines, firstFlight, inService);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumberOfEngines() {
		return numberOfEngines;
	}

	public void setNumberOfEngines(int numberOfEngines) {
		this.numberOfEngines = numberOfEngines;
	}

	public LocalDate getFirstFlight() {
		return firstFlight;
	}

	public void setFirstFlight(LocalDate firstFlight) {
		this.firstFlight = firstFlight;
	}

	public boolean isInService() {
		return inService;
	}

	public void setInService(boolean inService) {
		this.inService = inService;
	}

}
