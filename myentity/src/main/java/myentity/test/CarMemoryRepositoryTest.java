package myentity.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.List;
import org.junit.Test;
import myentity.CarDTO;
import myentity.CarMemoryRepository;

public class CarMemoryRepositoryTest {

	@Test
	public void findAll_Empty() {

		// GIVEN
		CarMemoryRepository carMemoryRepository = new CarMemoryRepository();

		// WHEN
		List<CarDTO> result = carMemoryRepository.findAll();

		// THEN
		assertEquals(0, result.size());

	}

	@Test
	public void findAll_NotEmpty() {

		// GIVEN
		CarMemoryRepository carMemoryRepository = new CarMemoryRepository();
		CarDTO carDto = new CarDTO();
		carDto.setBrand("Honda");
		carDto.setType("Jazz");
		carDto.setRegistered(2020);
		carDto.setCylinderCapacity(1.3);
		carDto.setId(2L);

		carMemoryRepository.save(carDto);

		// WHEN
		List<CarDTO> result = carMemoryRepository.findAll();

		// THEN
		assertEquals(1, result.size());
		assertEquals(carDto, result.get(0));
	}

	@Test
	public void findCarById() {

		// GIVEN
		CarMemoryRepository carMemoryRepository = new CarMemoryRepository();

		Long id = 2L;
		CarDTO carDto = new CarDTO();

		carDto.setBrand("Honda");
		carDto.setType("Jazz");
		carDto.setRegistered(2020);
		carDto.setCylinderCapacity(1.3);
		carDto.setId(id);

		carMemoryRepository.save(carDto);

		// WHEN
		int result = carMemoryRepository.findCarById(id);

		// THEN
		assertEquals(0, result);
	}

	@Test
	public void findCarById_NotFound() {

		// GIVEN
		CarMemoryRepository carMemoryRepository = new CarMemoryRepository();

		Long id = 2L;
		Long notExistingId = 4L;
		CarDTO carDto = new CarDTO();

		carDto.setBrand("Honda");
		carDto.setType("Jazz");
		carDto.setRegistered(2020);
		carDto.setCylinderCapacity(1.3);
		carDto.setId(id);

		carMemoryRepository.save(carDto);

		// WHEN
		int result = carMemoryRepository.findCarById(notExistingId);

		// THEN
		assertEquals(-1, result);
	}

	@Test
	public void deleteById_exists() {

		// GIVEN
		CarMemoryRepository carMemoryRepository = new CarMemoryRepository();

		Long id = 2L;
		CarDTO carDto = new CarDTO();

		carDto.setBrand("Honda");
		carDto.setType("Jazz");
		carDto.setRegistered(2020);
		carDto.setCylinderCapacity(1.3);
		carDto.setId(id);

		carMemoryRepository.save(carDto);

		// WHEN
		carMemoryRepository.deleteById(id);

		// THEN
		assertEquals(0, carMemoryRepository.findAll().size());
	}

	@Test
	public void deleteById_notExists() {

		// GIVEN
		CarMemoryRepository carMemoryRepository = new CarMemoryRepository();

		Long id = 2L;
		Long notExistingId = 4L;
		CarDTO carDto = new CarDTO();

		carDto.setBrand("Honda");
		carDto.setType("Jazz");
		carDto.setRegistered(2020);
		carDto.setCylinderCapacity(1.3);
		carDto.setId(id);

		carMemoryRepository.save(carDto);

		// WHEN
		carMemoryRepository.deleteById(notExistingId);

		// THEN
		assertEquals(1, carMemoryRepository.findAll().size());
	}

	@Test
	public void getById_Exists() {

		// GIVEN
		CarMemoryRepository carMemoryRepository = new CarMemoryRepository();

		Long id = 2L;
		CarDTO carDto = new CarDTO();

		carDto.setBrand("Honda");
		carDto.setType("Jazz");
		carDto.setRegistered(2020);
		carDto.setCylinderCapacity(1.3);
		carDto.setId(id);

		carMemoryRepository.save(carDto);

		// WHEN
		CarDTO dto = carMemoryRepository.getById(id);

		// THEN
		assertEquals(carDto, dto);
	}

	@Test
	public void getById_notExists() {

		// GIVEN
		CarMemoryRepository carMemoryRepository = new CarMemoryRepository();

		Long id = 2L;
		Long notExistingId = 4L;
		CarDTO carDto = new CarDTO();

		carDto.setBrand("Honda");
		carDto.setType("Jazz");
		carDto.setRegistered(2020);
		carDto.setCylinderCapacity(1.3);
		carDto.setId(id);

		carMemoryRepository.save(carDto);

		// WHEN
		CarDTO dto = carMemoryRepository.getById(notExistingId);

		// THEN
		assertNull(dto);
	}

	@Test
	public void save_update() {

		// GIVEN
		CarMemoryRepository carMemoryRepository = new CarMemoryRepository();

		Long id = 2L;
		CarDTO carDto = new CarDTO();

		carDto.setBrand("Honda");
		carDto.setType("Jazz");
		carDto.setRegistered(2020);
		carDto.setCylinderCapacity(1.3);
		carDto.setId(id);

		carMemoryRepository.save(carDto);

		// WHEN
		CarDTO carDto2 = new CarDTO();
		carDto2.setBrand("Hyundai");
		carDto2.setType("i20");
		carDto2.setRegistered(2015);
		carDto2.setCylinderCapacity(1.2);
		carDto2.setId(id);

		carMemoryRepository.save(carDto2);

		// THEN
		List<CarDTO> carDtoList = carMemoryRepository.findAll();

		assertEquals(1, carDtoList.size());
		assertEquals(carDto2, carDtoList.get(0));
	}

}
