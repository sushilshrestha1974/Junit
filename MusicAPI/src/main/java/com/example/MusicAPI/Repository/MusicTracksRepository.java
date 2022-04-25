package com.example.MusicAPI.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.MusicAPI.Model.MusicTracks;

@Repository

public interface MusicTracksRepository extends JpaRepository<MusicTracks,Long>  {

}