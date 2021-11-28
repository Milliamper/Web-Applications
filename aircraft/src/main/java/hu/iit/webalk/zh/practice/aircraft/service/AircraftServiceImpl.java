package hu.iit.webalk.zh.practice.aircraft.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import hu.iit.webalk.zh.practice.aircraft.exceptions.NoSuchEntityException;
import hu.iit.webalk.zh.practice.aircraft.repository.Aircraft;
import hu.iit.webalk.zh.practice.aircraft.repository.AircraftRepository;

@Service
public class AircraftServiceImpl implements AircraftService {

	private final AircraftRepository aircraftRepository;

	public AircraftServiceImpl(AircraftRepository aircraftRepository) {
		super();
		this.aircraftRepository = aircraftRepository;
	}

	@Override
	public Iterable<Aircraft> getAllAircraft() {

		List<Aircraft> aircraftList = new ArrayList<>();
		for (Aircraft aircraft : aircraftRepository.findAll()) {
			aircraftList.add(aircraft);
		}
		return aircraftList;

	}

	@Override
	public Iterable<? extends Aircraft> findByEngineNumberGreatherThan(int numberOfEngines) {
		return StreamSupport
				.stream(aircraftRepository.findAllBynumberOfEnginesGreaterThanEqual(numberOfEngines).spliterator(),
						false)
				.map(Aircraft::new).collect(Collectors.toList());
	}
	

	@Override
	public void save(Aircraft aircraft) {
		Optional<Aircraft> optionalAircraft = aircraftRepository.findById(aircraft.getId());
		if (optionalAircraft.isEmpty()) {
			throw new NoSuchEntityException(aircraft.getId());
		}
		aircraftRepository.save(aircraft.toEntity());
	}

	@Override
	public void delete(Long id) {
		aircraftRepository.deleteById(id);
	}

	@Override
	public Aircraft create(Aircraft aircraft) {
		return new Aircraft(aircraftRepository.save(aircraft.toEntity()));
	}

	@Override
	public Aircraft getById(Long id) {
		Optional<Aircraft> optionalAircraft = aircraftRepository.findById(id);
		if (optionalAircraft.isEmpty()) {
			throw new NoSuchEntityException(id);
		}
		return new Aircraft(optionalAircraft.get());
	}

}
