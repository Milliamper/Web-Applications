package hu.me.iit.webalk.first;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	

	@GetMapping(path = "articles/", produces = MediaType.APPLICATION_JSON_VALUE)

//	List<ArticlesDto> allArticles() {
//		return articles;
//	}
//
//	@PostMapping(path = "articles/")
//	void newArticle(@RequestBody @Valid ArticlesDto articlesDto) {
//		articles.add(articlesDto);
//	}


	@PutMapping(path = "articles/{id}")
	void replaceArticle(@PathVariable("id") String id, @RequestBody @Valid ArticlesDto articlesDto) {

		
	}

	@DeleteMapping(path = "articles/{id}")
	public void deleteArticle(@PathVariable("id") String id) {
		

	}

}
