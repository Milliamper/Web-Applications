package hu.iit.webalk.database.service;

public interface PeopleService {

	Iterable<People> getAllPeople();

	void delete(Long id);

	People create(People toPeople);

	People getById(Long id);

	void save(People people);

}
