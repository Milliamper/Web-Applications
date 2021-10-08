package myentity;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "car")
public class MainController {

	private final CarService carservice;

	public MainController(CarService carservice) {
		super();
		this.carservice = carservice;
	}

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CarDTO> allCars() {
		return carservice.findAll();
	}

	@PostMapping(path = "")
	public void newCar(@RequestBody @Valid CarDTO carDto) {
		carservice.save(carDto);
	}

	@PutMapping(path = "/")
	public void replaceCar(@RequestBody @Valid CarDTO carDto) {
		carservice.save(carDto);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteCar(@PathVariable("id") Long id) {
		carservice.deleteById(id);
	}

}
