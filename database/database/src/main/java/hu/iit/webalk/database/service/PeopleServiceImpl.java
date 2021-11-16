package hu.iit.webalk.database.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import hu.iit.webalk.database.exceptions.NoSuchEntityException;
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
		peopleDb.setAge(toPeople.getAge());
		peopleDb.setName(toPeople.getName());
		
		return peopleRepository.save(new hu.iit.webalk.database.repository.People());
	}


//	public Iterable<People> getAllPeople() {
//
//		List<People> rv = new ArrayList<>();
//
//		for (hu.iit.webalk.database.repository.People people : peopleRepository.findAll()) {
//			rv.add(new People(people));
//		}
//
//		return rv;
//	}

	@Override
	public void delete(Long id) {
		try {
			peopleRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchEntityException();
		}
	}

	@Override
	public hu.iit.webalk.database.service.People create(hu.iit.webalk.database.service.People toPeople) {
		return new People(peopleService.save(toPeople.toEntity()));
	}

	@Override
	public hu.iit.webalk.database.service.People getById(Long id) {
		Optional<hu.iit.webalk.database.repository.People> optionalPeople = peopleRepository.findById(id);
		if(optionalPeople.isEmpty()) {
			throw new NoSuchEntityException();
		}
		return new People(optionalPeople.get());
	}

	@Override
	public Iterable<People> getAllPeople() {
		return StreamSupport.stream(peopleRepository.findAll().spliterator(), false)
			.map(People::new)
			.collect(Collectors.toList());
		
	}

	@Override
	public void save(hu.iit.webalk.database.service.People people) {
		
		Optional<hu.iit.webalk.database.repository.People> optionalPeople = peopleRepository.findById(people.getId());
		if(optionalPeople.isEmpty()) {
			throw new NoSuchEntityException(people.getId());
		}
		
		peopleRepository.save(people.toEntity());
		
	}

	

}
