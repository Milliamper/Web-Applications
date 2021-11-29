package hu.iit.webalk.zh.practice.music.service;

import hu.iit.webalk.zh.practice.music.repository.Music;

public interface MusicService {

	Iterable<Music> getAllMusic();

	public Music create(Music music);

	void save(Music music);

	void delete(Long id);

	public Music getById(Long id);

}
