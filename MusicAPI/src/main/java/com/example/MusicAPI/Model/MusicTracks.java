package com.example.MusicAPI.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "musicapi_tracks")

public class MusicTracks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tracks_id")
	private Long id;

	@Column(name = "name")
	private String Name;

	@Column(name = "genre")
	private String Genre;

	@Column(name = "artist")
	private String Artist;

	@Column(name = "durationInSeconds")
	private int DurationInSeconds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getartist() {
		return Artist;
	}
	public void setartist(String Artist) {
		this.Artist=Artist;
	}

	public String getGenre() {
		return Genre;
	}

	public void setgenre(String Genre) {
		this.Genre = Genre;
	}

	public int get(int durationInSeconds) {
		return durationInSeconds;
	}

	public void setdurationInSeconds(int durationInSeconds, int DurationInSeconds) {
		this.DurationInSeconds = DurationInSeconds;
	}

	
	



}
