package hu.iit.webalk.zh.practice.music.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MusicRepository extends PagingAndSortingRepository<Music, Long>{
	
	Iterable<Music> findByTitleAndLength(String title, Integer length);
	
	Music findFirstByOrderByLengthAsc(); //növekvő
	
	Music findTopByOrderByLengthDesc();
	
	List<Music> findFirst10ByTitle(String title, Sort sort);

	List<Music> findTop10ByPerfomer(String performer, Pageable pageable);

}
