package hu.me.iit.webalk.first;

import java.util.List;

public interface ArticleRepository {

	List<ArticlesDto> findAll();

	ArticlesDto getById();

	Long save(ArticlesDto articlesdto);

	void deleteById(Long id);

}
