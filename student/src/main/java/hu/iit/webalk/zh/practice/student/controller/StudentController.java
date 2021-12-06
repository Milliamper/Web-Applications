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

import hu.iit.webalk.zh.practice.student.service.Student;
import hu.iit.webalk.zh.practice.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping()
	public Iterable<StudentDTO> getAllStudent() {
		List<StudentDTO> studentDtoList = new ArrayList<>();

		for (Student student : studentService.getAllStudent()) {
			studentDtoList.add(new StudentDTO(student));
		}
		return studentDtoList;
	}

	@PostMapping(consumes = "application/json")
	public StudentDTO create(@RequestBody @Valid StudentCreateDTO studentCreateDto) {
		return new StudentDTO(studentService.create(studentCreateDto.toStudent()));
	}

	@PutMapping()
	public void save(@RequestBody @Valid StudentDTO studentDto) {
		studentService.save(studentDto.toStudent());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		studentService.delete(id);
	}

	@GetMapping("/HighestBalance/{id}")
	Iterable<StudentDTO> getHighestBalance(@PathVariable("type") Integer type) {
		List<StudentDTO> studentDtoList = new ArrayList<>();
		for (Student student : studentService.getHighestBalance(type)) {
			studentDtoList.add(new StudentDTO(student));
		}
		return studentDtoList;
	}
}
