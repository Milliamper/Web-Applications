package hu.iit.webalk.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
