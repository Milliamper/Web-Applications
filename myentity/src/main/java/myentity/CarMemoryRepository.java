package myentity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CarMemoryRepository implements CarRepository {

	private final List<CarDTO> cars = new ArrayList<>();

	private int findCarById(Long id) {
		int found = -1;
		for (int i = 0; i < cars.size(); i++) {
			if (cars.get(i).getType().equals(id)) {
				found = i;
				break;
			}
		}
		return found;
	}

	@Override
	public List<CarDTO> findAll() {
		return cars;
	}

	@Override
	public CarDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(CarDTO cardto) {
		int found = findCarById(cardto.getId());

		if (found != -1) {
			CarDTO foundCar = cars.get(found);
			foundCar.setBrand(cardto.getBrand());
			foundCar.setType(cardto.getType());
			foundCar.setCylinderCapacity(cardto.getCylinderCapacity());
			foundCar.setRegistered(cardto.getRegistered());
		} else {

		}
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
