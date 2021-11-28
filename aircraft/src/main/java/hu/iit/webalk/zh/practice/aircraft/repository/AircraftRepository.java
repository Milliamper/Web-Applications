package hu.iit.webalk.zh.practice.aircraft.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AircraftRepository extends PagingAndSortingRepository<Aircraft, Long>{
	Iterable<Aircraft> findAllBynumberOfEnginesGreaterThanEqual(int numberOfEngines);
}
