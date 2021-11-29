package hu.iit.webalk.zh.practice.music.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.iit.webalk.zh.practice.music.repository.Music;
import hu.iit.webalk.zh.practice.music.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {

	private final MusicService musicService;

	public MusicController(MusicService musicService) {
		super();
		this.musicService = musicService;
	}

	@GetMapping()
	public Iterable<MusicDTO> getAllMusic() {
		List<MusicDTO> musicList = new ArrayList<>();
		for (Music music : musicService.getAllMusic()) {
			musicList.add(new MusicDTO(music));
		}
		return musicList;
	}

	@PostMapping(consumes = "application/json") // insert / update
	public MusicDTO save(@RequestBody @Valid MusicCreateDTO musicCreateDto) {
		return new MusicDTO(musicService.create(musicCreateDto.toMusic()));
	}

	@PutMapping()
	public void put(@RequestBody @Valid MusicDTO musicDto) {
		musicService.save(musicDto.toMusic());
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam("id") Long id) {
		musicService.delete(id);
	}

	@GetMapping("/{id}")
	public MusicDTO getById(@PathVariable("id")Long id) {
		return new MusicDTO(musicService.getById(id));
	}
}
