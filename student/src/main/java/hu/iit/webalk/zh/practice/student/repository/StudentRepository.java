package hu.iit.webalk.zh.practice.student.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
	Iterable<Student> findByisActiveStatus(Boolean isActiveStatus);
}
