package hu.iit.webalk.zh.practice.aircraft.service;

import hu.iit.webalk.zh.practice.aircraft.repository.Aircraft;

public interface AircraftService {
	
	Iterable<Aircraft> getAllAircraft();
	
	Iterable<? extends Aircraft> findByEngineNumberGreatherThan(int numberOfEngines);
	
	void save(Aircraft aircraft);
	
	void delete (Long id);
	
	Aircraft create(Aircraft Aircraft);
	
	Aircraft getById(Long id);
	

}
