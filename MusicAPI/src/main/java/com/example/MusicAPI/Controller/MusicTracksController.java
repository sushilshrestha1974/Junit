package com.example.MusicAPI.Controller;




import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MusicAPI.Model.MusicTracks;
import com.example.MusicAPI.Service.MusicTracksService;

@RestController
@RequestMapping("/api")

public class MusicTracksController {
	@Autowired
	MusicTracks tracksService;
	
	/*@GetMapping("/employees/template")
	public List<Employee> templateEmoloyees(Model model){
		model.addAttribute("employees", empService.getEmployee());
			
	}*/
	@RequestMapping (value="/MusicAPI", method=RequestMethod.POST)
	public MusicTracks createMusicTracks(@RequestBody MusicTracks tracks){
		return tracksService.createMusicTracks(tracks);
	}
	
	@RequestMapping(value="/MusicTracks", method = RequestMethod.GET)
		public List<MusicTracks> readMusicAPI(){
		return tracksService.getMusicTracks();
	}
	@RequestMapping (value ="/e/{stracksid}", method=RequestMethod.PUT)
	public MusicTracks readEmployees(@PathVariable(value = "tacksId") Long id, @RequestBody MusicTracks stracksDetails){
		return empService.updateEmployee(id, stracksDetails);
		}
	@RequestMapping(value= "/MusicAPI/{tracksId}", method=RequestMethod.DELETE)
			public void deleteEmployees(@PathVariable(value = "tracksId") Long id){
		tracksService.deleteMusicTracks(id);
		
				
			}
	

}