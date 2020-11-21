package br.com.ciandt.playlist.service;

import br.com.ciandt.playlist.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicService {
    @Autowired
    private MusicRepo musicRepo;

    public Music findMusic(final String musicId) {
        return musicRepo.getOne(musicId);
    }
}
