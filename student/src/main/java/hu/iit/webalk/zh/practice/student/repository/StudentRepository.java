package hu.iit.webalk.zh.practice.student.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long>{
	// adja vissza a legmagasabb össszeggel rendelkező oktatót/hallgatót
	Iterable<? extends Student> getFirstbyTypeOrderByBalanceDesc(Integer type);
}