package hu.me.iit.webalk.first;

public class ArticlesDto {

	private String author;
	private Integer page;
	private String title;
	private Integer pages;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Articles [author=" + author + ", page=" + page + ", title=" + title + ", pages=" + pages + "]";
	}

}
