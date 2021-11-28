package hu.iit.webalk.zh.practice.aircraft.controller;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import hu.iit.webalk.zh.practice.aircraft.repository.Aircraft;

public class AircraftCreateDTO {

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

	public AircraftCreateDTO(@NotEmpty String manufacturer, @NotEmpty String model, @Min(1) @Max(6) int numberOfEngines,
			LocalDate firstFlight, @NotEmpty boolean inService) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.numberOfEngines = numberOfEngines;
		this.firstFlight = firstFlight;
		this.inService = inService;
	}

	public AircraftCreateDTO() {

	}

	public AircraftCreateDTO(Aircraft aircraft) {
		this.manufacturer = aircraft.getManufacturer();
		this.model = aircraft.getModel();
		this.numberOfEngines = aircraft.getNumberOfEngines();
		this.firstFlight = aircraft.getFirstFlight();
		this.inService = aircraft.isInService();
	}

	public Aircraft toAircraft() {
		return new Aircraft(null, manufacturer, model, numberOfEngines, firstFlight, inService);
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
