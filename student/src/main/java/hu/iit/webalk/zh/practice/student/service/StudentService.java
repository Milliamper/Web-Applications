package hu.iit.webalk.zh.practice.student.service;

public interface StudentService {
	
	Iterable<Student> getAllStudent();
	
	Student create (Student student);
	
	void save (Student student);
	
	void delete(Long id);
	
	Iterable<? extends Student> getHighestBalance(Integer type);
 
}
