package hu.iit.webalk.zh.practice.house.service;

import hu.iit.webalk.zh.practice.house.repository.House;

public interface HouseService {
	
	Iterable<House> getAllHouse();
	
	House create (House house);
	
	void save (House house);
	
	void delete (Long id);
	
	House findById (Long id);
	
	Iterable<House> findPassive(Boolean isPassive);

}
