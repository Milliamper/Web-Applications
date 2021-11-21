package hu.iit.webalk.database.service;

public interface PeopleService {

	Iterable<People> getAllPeople();
	
	Iterable<? extends People> findByAgeGreatherThan(int age);
	
	void save(People people);

	void delete(Long id);

	People create(People toPeople);

	People getById(Long id);



}
