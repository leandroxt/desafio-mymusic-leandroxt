package br.com.ciandt.music.repository;

import br.com.ciandt.music.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepo extends JpaRepository<Music, String> {
    List<Music> findByNomeContaining(final String name);
}
