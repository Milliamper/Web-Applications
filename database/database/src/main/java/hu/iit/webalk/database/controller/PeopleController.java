package hu.iit.webalk.database.controller;

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

import hu.iit.webalk.database.service.People;
import hu.iit.webalk.database.service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {

	private final PeopleService peopleService;

	public PeopleController(PeopleService peopleService) {
		super();
		this.peopleService = peopleService;
	}

	@GetMapping()
	public Iterable<PeopleDTO> getAllPeople() {
		List<PeopleDTO> peopleDtoList = new ArrayList<>();

		for (People people : peopleService.getAllPeople()) {
			peopleDtoList.add(new PeopleDTO(people));
		}

		return peopleDtoList;
	}

	@PostMapping(consumes = "application/json")
	public PeopleDTO save(@RequestBody @Valid PeopleCreateDTO peopleCreateDto) {
		return new PeopleDTO(peopleService.create(peopleCreateDto.toPeople()));
	}

	@DeleteMapping("/{id}") // ezzel jelölöm hogy az URL-ben hol van az a rész amit ki szeretnék venni
	public void delete(@PathVariable("id") Long id) {
		peopleService.delete(id);
	}

	@GetMapping("/{id}")
	public PeopleDTO getById(@PathVariable("id") Long id) {
		return new PeopleDTO(peopleService.getById());
	}

	@PutMapping
	void put(@RequestBody @Valid PeopleDTO peopleDto) {
		peopleService.save(peopleDto.toPeople());
	}

	@GetMapping("/findByAgeGt")
	void findAdultPeople(@RequestParam("age") int age) {
		peopleService.save(findByAgeGreaterThan(age));
	}

}
