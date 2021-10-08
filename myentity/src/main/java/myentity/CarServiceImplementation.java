package myentity;

import java.util.List;

import org.springframework.stereotype.Component;

import myentity.exception.TooMuchCarException;

@Component
public class CarServiceImplementation implements CarService {

	private final int MAXIMUM_NUMBER_OF_CARS = 10;
	private final CarRepository carRepository;

	public CarServiceImplementation(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	@Override
	public List<CarDTO> findAll() {
		return carRepository.findAll();
	}

	@Override
	public CarDTO getById(Long id) {
		return carRepository.getById(id);
	}

	@Override
	public Long save(CarDTO cardto) {
		if (carRepository.findAll().size() >= MAXIMUM_NUMBER_OF_CARS) {
			throw new TooMuchCarException();
		}
		return carRepository.save(cardto);
	}

	@Override
	public void deleteById(Long id) {
		carRepository.deleteById(id);

	}

}
