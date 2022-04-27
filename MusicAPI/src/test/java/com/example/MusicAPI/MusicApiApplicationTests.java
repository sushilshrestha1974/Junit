package com.example.MusicAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.MusicAPI.Model.MusicTracks;
import com.example.MusicAPI.Repository.MusicTracksRepository;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class MusicApiApplicationTests {
 
	@Autowired
	MusicTracksRepository mtRepo;
	
		@Test
		@Order(1)
		public void testCreate() {
			MusicTracks mt = new MusicTracks();
			mt.setId(1L);
			mt.setName("cold moon");
			mt.setArtist("Sushil");
			mt.setGenre("Rock");
			mt.setDurationInSeconds(180);
			mtRepo.save(mt);
			assertNotNull(mtRepo.findById(1L).get());
		  }
		@Test
		@Order(2)
		public void testReadAll() {
			List<MusicTracks> list= mtRepo.findAll();
			assertTrue(list.size()>0);
		}
		@Test
		@Order(3)
		public void testSingleMusicTracks() { 
			MusicTracks music=mtRepo.findById(1L).get();
			assertEquals("cold moon", music.getName());
			}	
		@Test
		@Order(4)
		public void testUpdate() {
			MusicTracks music=mtRepo.findById(1L).get();
			music.setDurationInSeconds(250); 
			mtRepo.save(music);
			assertNotEquals(190, mtRepo.findById(1L).get().getDurationInSeconds());
			}
		@Test
		@Order(5)
		public void testDelete() {
		mtRepo.deleteById(1L);
		assertFalse(mtRepo.existsById(1L));
		}
		
}
