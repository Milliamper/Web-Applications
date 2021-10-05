package hu.me.iit.webalk.first;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	private final List<ArticlesDto> articles = new ArrayList();

	@GetMapping(path = "articles/", produces = MediaType.APPLICATION_JSON_VALUE)

	List<ArticlesDto> allArticles() {
		return articles;
	}

	@PostMapping(path = "articles/")
	void newArticle(@RequestBody @Valid ArticlesDto articlesDto) {
		articles.add(articlesDto);
	}

	private int findArticleById(String id) {
		int found = -1;

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getTitle().equals(id)) {
				found = i;
				break;
			}
		}
		return found;
	}

	@PutMapping(path = "articles/{id}")
	void replaceArticle(@PathVariable("id") String id, @RequestBody @Valid ArticlesDto articlesDto) {

		int found = findArticleById(id);

		if (found != -1) {
			ArticlesDto foundArticle = articles.get(found);
			foundArticle.setAuthor(articlesDto.getAuthor());
			foundArticle.setPages(articlesDto.getPages());
		}
	}

	@DeleteMapping(path = "articles/{id}")
	public void deleteArticle(@PathVariable("id") String id) {
		int found = findArticleById(id);

		if (found != -1) {
			articles.remove(found);
		}

	}

}
