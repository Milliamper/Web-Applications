package hu.iit.webalk.zh.practice.house.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import hu.iit.webalk.zh.practice.house.exceptions.NoSuchEntityException;
import hu.iit.webalk.zh.practice.house.repository.House;
import hu.iit.webalk.zh.practice.house.repository.HouseRepository;

@Service
public class HouseServiceImpl implements HouseService {

	private final HouseRepository houseRepository;

	public HouseServiceImpl(HouseRepository houseRepository) {
		super();
		this.houseRepository = houseRepository;
	}

	@Override
	public Iterable<House> getAllHouse() {
		List<House> studentList = new ArrayList<>();
		for (House house : houseRepository.findAll()) {
			studentList.add(new House(house));
		}
		return studentList;
	}

	@Override
	public House create(House house) {
		return new House(houseRepository.save(house.toEntity()));
	}

	@Override
	public void save(House house) {
		Optional<House> optionalHouse = houseRepository.findById(house.getId());
		if (optionalHouse.isEmpty()) {
			throw new NoSuchEntityException(house.getId());
		}
		houseRepository.save(house.toEntity());
	}

	@Override
	public void delete(Long id) {
		try {
			houseRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchEntityException(id);
		}
	}

	@Override
	public House findById(Long id) {
		Optional<House> optionalHouse = houseRepository.findById(id);
		if (optionalHouse.isEmpty()) {
			throw new NoSuchEntityException(id);
		}
		return new House(optionalHouse.get());
	}

	@Override
	public Iterable<House> findPassive(Boolean passiveHouse) {
		return StreamSupport.stream(houseRepository.findByPassiveHouse(passiveHouse).spliterator(), false)
				.map(House::new).collect(Collectors.toList());
	}
}
