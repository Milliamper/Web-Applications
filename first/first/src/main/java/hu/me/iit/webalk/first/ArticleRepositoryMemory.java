package hu.me.iit.webalk.first;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryMemory implements ArticleRepository{
	
	private final List<ArticlesDto> articles = new ArrayList<>();
	
	private int findArticleById(Long id) {
		int found = -1;

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getTitle().equals(id)) {
				found = i;
				break;
			}
		}
		return found;
	}

	@Override
	public List<ArticlesDto> findAll() {
		return articles;
	}

	@Override
	public ArticlesDto getById() {
		return null;
	}

	@Override
	public Long save(ArticlesDto articlesdto) {
		int found = findArticleById(articlesdto.getId());

		if (found != -1) {
			ArticlesDto foundArticle = articles.get(found);
			foundArticle.setAuthor(articlesdto.getAuthor());
			foundArticle.setPages(articlesdto.getPages());
		} else {
			
		}
		return null;
	}

	@Override
	public void deleteById(Long id) {
		
		int found = findArticleById(id);

		if (found != -1) {
			articles.remove(found);
		}
		
	}

}
