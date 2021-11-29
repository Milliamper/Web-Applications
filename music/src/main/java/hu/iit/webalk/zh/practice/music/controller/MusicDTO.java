package hu.iit.webalk.zh.practice.music.controller;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import hu.iit.webalk.zh.practice.music.repository.Music;

public class MusicDTO {

	private Long id;
	@NotBlank
	private String title;
	private String perfomer;
	@Min(1)
	private int length;
	private boolean isTechno;
	@DateTimeFormat
	private LocalDate publishDate;
	
	
	
	public MusicDTO(Long id, @NotBlank String title, String perfomer, @Min(1) int length, boolean isTechno,
			LocalDate publishDate) {
		super();
		this.id = id;
		this.title = title;
		this.perfomer = perfomer;
		this.length = length;
		this.isTechno = isTechno;
		this.publishDate = publishDate;
	}
	
	public Music toMusic () {
		return new Music(id, title, perfomer, length, isTechno, publishDate);
	}

	public MusicDTO (Music music) {
		this.id = music.getId();
		this.title = music.getTitle();
		this.perfomer = music.getPerfomer();
		this.length = music.getLength();
		this.isTechno = music.isTechno();
		this.publishDate = music.getPublishDate();
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
