package com.example.MusicAPI.Controller;




import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MusicAPI.Model.MusicTracks;
import com.example.MusicAPI.Service.MusicTracksService;

@RestController
@RequestMapping("/music")

public class MusicTracksController {
	@Autowired
	MusicTracksService tracksService;
	
	/*@GetMapping("/employees/template")
	public List<Employee> templateEmoloyees(Model model){
		model.addAttribute("employees", empService.getEmployee());
			
	}*/
	@PostMapping ("/track")
	public MusicTracks createMusicTracks(@RequestBody MusicTracks tracks){
		return tracksService.createMusicTracks(tracks);
	}

	@GetMapping ("/track")
		public List<MusicTracks> readMusicAPI(){
		return tracksService.getMusicTracks();
	}
	@PatchMapping ("/track/{id}")
	public MusicTracks readMusic(@PathVariable(value = "id") Long id, @RequestBody MusicTracks tracksDetails){
		return tracksService.updateMusicTracks( id, tracksDetails);
		}
	@RequestMapping(value= "/track/{id}", method=RequestMethod.DELETE)
			public void deleteMusic(@PathVariable(value = "id") Long id){
		tracksService.deleteMusicTracks(id);
						
			}
	@PatchMapping ("/track/{id}/{newName}")
	public MusicTracks updateMusic(@PathVariable(value = "id") Long id, @PathVariable (value =  "newName") String newName){
		return tracksService.patchMusicTracks( id, newName);
		}

}