package com.example.MusicAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MusicAPI.Model.MusicTracks;
import com.example.MusicAPI.Repository.MusicTracksRepository;
import java.util.List;

@Service
public class MusicTracksService {
	
	@Autowired
	MusicTracksRepository tracksRepository;
	
	//Create
	public MusicTracks createMusicTracks(MusicTracks tracks) {
		return tracksRepository.save(tracks);
	}
	//Read	
	public List<MusicTracks>getMusicTracks(){
		return tracksRepository.findAll();
		}
	//Delete
	public void deleteMusicTracks(Long tracksId) {
		tracksRepository.deleteById(tracksId);		
	}
	//Update
	public MusicTracks updateMusicTracks(Long Id, MusicTracks MusicAPIDetails) {
		Long tracksId;
		MusicTracks tracks=tracksRepository.findById(Id).get();
		tracks.setName(MusicAPIDetails.getName());
		tracks.setgenre(MusicAPIDetails.getGenre());
		tracks.setartist(MusicAPIDetails.getartist());
		tracks.setId(MusicAPIDetails.getId());
		
		return tracksRepository.save(tracks);
		
		
	}
}

