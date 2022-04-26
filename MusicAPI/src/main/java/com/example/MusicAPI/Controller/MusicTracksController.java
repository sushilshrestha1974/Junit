package com.example.MusicAPI.Controller;




import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping (value="/track", method=RequestMethod.POST)
	public MusicTracks createMusicTracks(@RequestBody MusicTracks tracks){
		return tracksService.createMusicTracks(tracks);
	}

	@GetMapping ("/track")
		public List<MusicTracks> readMusicAPI(){
		return tracksService.getMusicTracks();
	}
	@RequestMapping (value ="/track/{id}", method=RequestMethod.PUT)
	public MusicTracks readMusic(@PathVariable(value = "id") Long id, @RequestBody MusicTracks tracksDetails){
		return tracksService.updateMusicTracks( id, tracksDetails);
		}
	@RequestMapping(value= "/track/{id}", method=RequestMethod.DELETE)
			public void deleteMusic(@PathVariable(value = "id") Long id){
		tracksService.deleteMusicTracks(id);
		
				
			}
	

}