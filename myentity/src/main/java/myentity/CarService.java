package myentity;

import java.util.List;

public interface CarService {
	
	List<CarDTO> findAll();
    CarDTO getById(Long id);
    Long save(CarDTO cardto);
    void deleteById(Long id);

}
