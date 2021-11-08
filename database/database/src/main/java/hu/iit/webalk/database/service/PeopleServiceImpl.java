package hu.iit.webalk.database.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.iit.webalk.database.repository.People;
import hu.iit.webalk.database.repository.PeopleRepository;

@Service
public class PeopleServiceImpl implements PeopleService {

	private final PeopleRepository peopleRepository;

	public PeopleServiceImpl(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	public People create(People toPeople) {
		
		hu.iit.webalk.database.repository.People peopleDb = new hu.iit.webalk.database.repository.People();
		peopleDb.setAge(people.getAge());
		peopleDb.setName(people.getName());
		
		
		return peopleRepository.save(new hu.iit.webalk.database.repository.People);
	}


	public Iterable<People> getAllPeople() {

		List<People> rv = new ArrayList<>();

		for (hu.iit.webalk.database.repository.People people : peopleRepository.findAll()) {
			rv.add(new People(people));
		}

		return rv;
	}

//	public Iterable<People> getAllPeople2() {
//		return StreamSupport.stream(peopleRepository.findAll().spliterator(),
//			.map(People:new)
//			.collect(Collectors.toList());
//		
//	}

}
