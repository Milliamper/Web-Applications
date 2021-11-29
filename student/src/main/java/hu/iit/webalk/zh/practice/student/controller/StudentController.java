package hu.iit.webalk.zh.practice.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.iit.webalk.zh.practice.student.repository.Student;
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
	public Iterable<StudentDTO> getAllPeople(){
		List<StudentDTO> studentDtoList = new ArrayList<>();
		for(Student student : studentService.getAllStudent()) {
			studentDtoList.add(new StudentDTO(student));
		}
		return studentDtoList;
	}
	
	@PostMapping(consumes = "application/json")
	public StudentDTO save(StudentCreateDTO studentCreateDto) {
		
	}
	

}
