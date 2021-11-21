package hu.iit.webalk.database;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.Matchers.*;

import hu.iit.webalk.database.repository.People;
import hu.iit.webalk.database.repository.PeopleRepository;

@SpringBootTest
@AutoConfigureMockMvc

class PeopleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PeopleRepository peopleRepository;
	
	@Test
	public void shouldReturnPeople() throws Exception {
		// GIVEN
		People people = new People(1L, 12, "1");

		Iterable<People> all = peopleRepository.findAll();
		peopleRepository.save(people);

		// WHEN THEN
		this.mockMvc.perform(get("/people"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].name", is("1")))
				.andExpect(jsonPath("$.[0].age", is(12)));
	}
	
	@Test
	public void shouldReturnPeople2() throws Exception {
		// GIVEN
		People people = new People(1L, 22, "2");

		Iterable<People> all = peopleRepository.findAll();
		peopleRepository.save(people);

		// WHEN THEN
		this.mockMvc.perform(get("/people"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].name", is("2")))
				.andExpect(jsonPath("$.[0].age", is(22)));
	}
	
	@Test
	public void shouldNoMainPage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is4xxClientError());
	}
}
