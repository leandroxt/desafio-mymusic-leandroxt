package br.com.ciandt.playlist.repository;

import br.com.ciandt.playlist.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepo extends JpaRepository<Playlist, String> {
    List<Playlist> findByUsuarioNomeIgnoreCase(String username);
}
