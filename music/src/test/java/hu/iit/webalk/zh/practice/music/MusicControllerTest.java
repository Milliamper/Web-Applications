package hu.iit.webalk.zh.practice.music;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import hu.iit.webalk.zh.practice.music.repository.Music;
import hu.iit.webalk.zh.practice.music.repository.MusicRepository;

@SpringBootTest
@AutoConfigureMockMvc
class MusicControllerTest {

	@Autowired
	private final MusicRepository musicRepository;
	
	@Autowired
	private final MockMvc mockMvc;

	public MusicControllerTest(MusicRepository musicRepository, MockMvc mockMvc) {
		super();
		this.musicRepository = musicRepository;
		this.mockMvc = mockMvc;
	}
	
	@Test
	public void shouldReturnMusic() throws Exception {
		Music music = new Music(1L, "Love Generation", "Bob Sinclar", 300, false, LocalDate.of(2009, 2, 4));
		
		Iterable<Music> all = musicRepository.findAll();
		musicRepository.save(music);
		
		this.mockMvc.perform(get("/music")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.[0].tile", is("Love Generation")));
	}


}
