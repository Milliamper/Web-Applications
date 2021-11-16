package hu.iit.webalk.database;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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
		People people = new People();
		peopleRepository.save(people);
		
		// WHEN THEN
		this.mockMvc.perform(get("/people").andDo(print()).andExpect().isOk());		
		
	}
	
	@Test
	public void shouldNoMainPage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is4xxClientError());
	}
}
