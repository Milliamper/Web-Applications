package hu.iit.webalk.zh.practice.house.controller;

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
import org.springframework.web.bind.annotation.RestController;

import hu.iit.webalk.zh.practice.house.repository.House;
import hu.iit.webalk.zh.practice.house.service.HouseService;

@RestController
@RequestMapping("/house")
public class HouseController {
	
	private final HouseService houseService;

	public HouseController(HouseService houseService) {
		super();
		this.houseService = houseService;
	}
	
	@GetMapping()
	public Iterable<HouseDTO> getAllHouse(){
		List<HouseDTO> studentDtoList = new ArrayList<>();
		for(House house : houseService.getAllHouse()) {
			studentDtoList.add(new HouseDTO(house));
		}
		return studentDtoList;
	}
	
	@PostMapping(consumes = "application/json") // insert / update
	public HouseDTO save (@RequestBody @Valid HouseCreateDTO houseCreateDto) {
		return new HouseDTO(houseService.create(houseCreateDto.toHouse()));
	}
	
	@PutMapping()
	public void put (HouseDTO houseDto) {
		houseService.create(houseDto.toHouse());
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		houseService.delete(id);
	}
	
	@GetMapping("/findPassive")
	public Iterable<HouseDTO> findPassive(Boolean passiveHouse){
		List<HouseDTO> studentDtoList = new ArrayList<>();
		for(House house : houseService.findPassive(passiveHouse)) {
			studentDtoList.add(new HouseDTO(house));
		}
		return studentDtoList;
	}
}
