package hu.iit.webalk.zh.practice.music.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hu.iit.webalk.zh.practice.music.exception.NoSuchEntityException;
import hu.iit.webalk.zh.practice.music.repository.Music;
import hu.iit.webalk.zh.practice.music.repository.MusicRepository;

@Service
public class MusicServiceImpl implements MusicService {

	public final MusicRepository musicRepostiory;

	public MusicServiceImpl(MusicRepository musicRepostiory) {
		super();
		this.musicRepostiory = musicRepostiory;
	}

	@Override
	public Iterable<Music> getAllMusic() {
		List<Music> musicList = new ArrayList<>();
		for (Music music : musicRepostiory.findAll()) {
			musicList.add(new Music(music));
		}
		return musicList;
	}

	@Override
	public Music create(Music music) {
		return new Music(musicRepostiory.save(music.toEntity()));
	}

	@Override
	public void save(Music music) {
		Optional<Music> optionalMusic = musicRepostiory.findById(music.getId());
		if (optionalMusic.isEmpty()) {
			throw new NoSuchEntityException(music.getId());
		}
		musicRepostiory.save(music.toEntity());

	}

	@Override
	public void delete(Long id) {
		try {
			musicRepostiory.deleteById(id);
		} catch (Exception e) {
			throw new NoSuchEntityException(id);
		}
	}

	@Override
	public Music getById(Long id) {
		Optional<Music> optionalMusic = musicRepostiory.findById(id);
		if (optionalMusic.isEmpty()) {
			throw new NoSuchEntityException(id);
		}
		return new Music(optionalMusic.get());
	}

}
