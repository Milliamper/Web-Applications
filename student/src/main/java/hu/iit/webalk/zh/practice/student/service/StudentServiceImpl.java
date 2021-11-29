package hu.iit.webalk.zh.practice.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import hu.iit.webalk.zh.practice.student.exception.NoSuchEntityException;
import hu.iit.webalk.zh.practice.student.repository.Student;
import hu.iit.webalk.zh.practice.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Iterable<Student> getAllStudent() {
		List<Student> studentList = new ArrayList<>();
		for (Student student : studentRepository.findAll()) {
			studentList.add(new Student(student));
		}
		return studentList;
	}

	@Override
	public Student create(Student student) {
		return new Student(studentRepository.save(student.toEntity()));
	}

	@Override
	public void save(Student student) {
		Optional<Student> optionalStudent = studentRepository.findById(student.getId());
		if (optionalStudent.isEmpty()) {
			throw new NoSuchEntityException(student.getId());
		}
		studentRepository.save(student.toEntity());

	}

	@Override
	public void delete(Long id) {
		try {
			studentRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchEntityException(id);
		}

	}

	@Override
	public Student getById(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isEmpty()) {
			throw new NoSuchEntityException(id);
		}
		return new Student(optionalStudent.get());
	}

	@Override
	public Iterable<? extends Student> findByActiveStatus(Boolean isActiveStatus) {
		return StreamSupport.stream(studentRepository.findByisActiveStatus(isActiveStatus).spliterator(), false)
				.map(Student::new).collect(Collectors.toList());
	}

}
