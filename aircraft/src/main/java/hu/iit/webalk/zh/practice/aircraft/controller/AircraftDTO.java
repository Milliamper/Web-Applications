package hu.iit.webalk.zh.practice.aircraft.controller;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import hu.iit.webalk.zh.practice.aircraft.repository.Aircraft;

public class AircraftDTO {

	private Long id;
	@NotEmpty
	private String manufacturer;
	@NotEmpty
	private String model;
	@Min(1)
	@Max(6)
	private int numberOfEngines;
	@DateTimeFormat
	private LocalDate firstFlight;
	private boolean inService;

	public AircraftDTO(Aircraft aircraft) {
		this.id = aircraft.getId();
		this.manufacturer = aircraft.getManufacturer();
		this.model = aircraft.getModel();
		this.numberOfEngines = aircraft.getNumberOfEngines();
		this.firstFlight = aircraft.getFirstFlight();
		this.inService = aircraft.isInService();
	}

	public Aircraft toAircraft() {
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
