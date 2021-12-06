package hu.iit.webalk.zh.practice.house;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import hu.iit.webalk.zh.practice.house.repository.House;
import hu.iit.webalk.zh.practice.house.repository.HouseRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class HouseControllerTest {
	
	@Autowired
	private final HouseRepository houseRepository;
	
	@Autowired
	private final MockMvc mockMvc;

	public HouseControllerTest(HouseRepository houseRepository, MockMvc mockMvc) {
		super();
		this.houseRepository = houseRepository;
		this.mockMvc = mockMvc;
	}
	
	@Test
	public void shouldReturnHouse() throws Exception{
		House house = new House(1L, "blue", 100, true);
		
		Iterable<House> all = houseRepository.findAll();
		houseRepository.save(house);
		
		this.mockMvc.perform(get("/house")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.[0].floorAreaInSquareMeter", is(100)));
	}
	
	

}
