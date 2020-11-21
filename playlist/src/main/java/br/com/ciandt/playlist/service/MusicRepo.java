package br.com.ciandt.playlist.service;

import br.com.ciandt.playlist.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepo extends JpaRepository<Music, String> {
}
