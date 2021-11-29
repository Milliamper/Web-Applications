package hu.iit.webalk.zh.practice.student;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import hu.iit.webalk.zh.practice.student.repository.Student;
import hu.iit.webalk.zh.practice.student.repository.StudentRepository;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void shouldReturnStudent() throws Exception {
		// GIVEN
		Student student = new Student(1L, "DTKUG0", true, 10_000, LocalDate.of(2019, 9, 2));

		Iterable<Student> all = studentRepository.findAll();
		studentRepository.save(student);

		// WHEN THEN
		this.mockMvc.perform(get("/student"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].neptunID", is("DTKUG0")))
				.andExpect(jsonPath("$.[0].balance", is(10_000)));
	}
	
	@Test
	public void shouldNoMainPage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is4xxClientError());
	}

}
