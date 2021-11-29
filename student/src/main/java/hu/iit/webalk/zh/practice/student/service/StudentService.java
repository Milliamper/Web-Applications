package hu.iit.webalk.zh.practice.student.service;

import hu.iit.webalk.zh.practice.student.repository.Student;

public interface StudentService {
	
	Iterable<Student> getAllStudent();
	
	Student create(Student Student);
	
	void save(Student student);
	
	void delete (Long id);
	
	Student getById(Long id);
	
	

}
