package hu.iit.webalk.zh.practice.house.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface HouseRepository extends PagingAndSortingRepository<House, Long>{
	Iterable<House> findByPassiveHouse(Boolean passiveHouse);

}
