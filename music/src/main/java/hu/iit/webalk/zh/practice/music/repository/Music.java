package hu.iit.webalk.zh.practice.music.repository;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Music {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String perfomer;
	private int length;
	private boolean isTechno;
	private LocalDate publishDate;

	public Music toEntity() {
		return new Music(id, title, perfomer, length, isTechno, publishDate);
	}

	public Music() {

	}

	public Music(Music music) {
		this.id = music.getId();
		this.title = music.getTitle();
		this.perfomer = music.getPerfomer();
		this.length = music.getLength();
		this.isTechno = music.isTechno();
		this.publishDate = music.getPublishDate();
	}

	public Music(Long id, String title, String perfomer, int length, boolean isTechno, LocalDate publishDate) {
		super();
		this.id = id;
		this.title = title;
		this.perfomer = perfomer;
		this.length = length;
		this.isTechno = isTechno;
		this.publishDate = publishDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPerfomer() {
		return perfomer;
	}

	public void setPerfomer(String perfomer) {
		this.perfomer = perfomer;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isTechno() {
		return isTechno;
	}

	public void setTechno(boolean isTechno) {
		this.isTechno = isTechno;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

}
