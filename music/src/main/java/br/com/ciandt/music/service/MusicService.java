package br.com.ciandt.music.service;

import br.com.ciandt.music.entity.Music;
import br.com.ciandt.music.repository.MusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    @Autowired
    private MusicRepo repo;

    public List<Music> findMusic(final String filter) {
        return repo.findByNomeContaining(filter);
    }
}
