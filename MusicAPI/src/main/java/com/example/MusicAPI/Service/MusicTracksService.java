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
		MusicTracks tracks=tracksRepository.findById(Id).get();
		tracks.setName(MusicAPIDetails.getName());
		tracks.setGenre(MusicAPIDetails.getGenre());
		tracks.setArtist(MusicAPIDetails.getArtist());
		return tracksRepository.save(tracks);
		}
	//Patch
	public MusicTracks patchMusicTracks(Long Id, String newName) {
		MusicTracks tracks=tracksRepository.findById(Id).get();
		tracks.setName(newName);
		
		return tracksRepository.save(tracks);
	}
}

