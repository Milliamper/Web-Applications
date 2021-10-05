package hu.me.iit.webalk.first;

import java.util.List;

public class ArticleServiceImpl implements ArticleService{

	//minden business logic itt van
	private final int MAXIMUM_ARTICLE_COUNT = 10;
	private ArticleRepository articleRepository;
	
	@Override
	public List<ArticlesDto> findAll() {
		// TODO Auto-generated method stub
		return articleRepository.findAll();
	}

	@Override
	public ArticlesDto getById() {
		// TODO Auto-generated method stub
		return articleRepository.getById();
	}

	@Override
	public Long save(ArticlesDto articlesdto) {
		if (articleRepository.findAll().size() >= MAXIMUM_ARTICLE_COUNT) {
				throw new TooMuchArticleException();
		}
		return articleRepository.save(articlesdto);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
