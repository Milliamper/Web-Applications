package hu.iit.webalk.zh.practice.aircraft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.iit.webalk.zh.practice.aircraft.repository.Aircraft;
import hu.iit.webalk.zh.practice.aircraft.service.AircraftService;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

	private final AircraftService aircraftService;

	public AircraftController(AircraftService aircraftService) {
		super();
		this.aircraftService = aircraftService;
	}

	@GetMapping()
	public Iterable<AircraftDTO> getAllAircraft() {
		List<AircraftDTO> aircraftDtoList = new ArrayList<>();

		for (Aircraft aircraft : aircraftService.getAllAircraft()) {
			aircraftDtoList.add(new AircraftDTO(aircraft));
		}
		return aircraftDtoList;
	}

	@GetMapping("{id}")
	public AircraftDTO getById(@PathVariable("id") Long id) {
		return new AircraftDTO(aircraftService.getById(id));
	}

	@PostMapping(consumes = "application/json")
	public AircraftDTO save(@RequestBody @Valid AircraftCreateDTO aircraftCreateDto) {
		return new AircraftDTO(aircraftService.create(aircraftCreateDto.toAircraft()));
	}

	@PutMapping
	void put(AircraftDTO aircraftDto) {
		aircraftService.save(aircraftDto.toAircraft());
	}

	@DeleteMapping("{id}")
	void delete(@PathVariable("id") Long id) {
		aircraftService.delete(id);
	}

	@GetMapping("/findByEngine")
	Iterable<AircraftDTO> findByEngineNumber(@RequestParam("numberOfEngines") int numberOfEngines) {
		List<AircraftDTO> aircraftDtoList = new ArrayList<>();
		for (Aircraft aircraft : aircraftService.findByEngineNumberGreatherThan(numberOfEngines)) {
			aircraftDtoList.add(new AircraftDTO(aircraft));
		}
		return aircraftDtoList;
	}

}
