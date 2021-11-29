package hu.iit.webalk.zh.practice.student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.iit.webalk.zh.practice.student.repository.Student;
import hu.iit.webalk.zh.practice.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController { // Ennek a rétegnek az a feladata, hogy a beérkező HTTP request-et elkapja,
									// kiszedje belőle az adatot, és utána továbbítsa az alatta lévő Service
									// rétegnek. Illetve a Service-től jövő válaszokat átalakítja HTTP response-ra.

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping()
	public Iterable<StudentDTO> getAllPeople() {
		List<StudentDTO> studentDtoList = new ArrayList<>();
		for (Student student : studentService.getAllStudent()) {
			studentDtoList.add(new StudentDTO(student));
		}
		return studentDtoList;
	}

	@GetMapping("/findByStatus")
	Iterable<StudentDTO> findActiveStatus(@RequestParam("isActiveStaus") boolean isActiveStatus) {
		List<StudentDTO> studentDtoList = new ArrayList<>();
		for (Student student : studentService.findByActiveStatus(isActiveStatus)) {
			studentDtoList.add(new StudentDTO(student));
		}
		return studentDtoList;
	}

	@PostMapping(consumes = "application/json") // insert / update
	public StudentDTO save(@RequestBody @Valid StudentCreateDTO studentCreateDto) {
		return new StudentDTO(studentService.create(studentCreateDto.toStudent()));
	}

	@PutMapping // update
	public void put(@RequestBody @Valid StudentDTO studentDto) {
		studentService.save(studentDto.toStudent());
	}

	@DeleteMapping("/{id}") // ezzel jelölöm hogy az URL-ben hol van az a rész amit ki szeretnék venni
	public void delete(@PathVariable("id") Long id) {
		studentService.delete(id);
	}

}
