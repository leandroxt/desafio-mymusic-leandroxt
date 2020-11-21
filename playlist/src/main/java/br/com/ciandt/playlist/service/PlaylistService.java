package br.com.ciandt.playlist.service;

import br.com.ciandt.playlist.Exceptions.NotFoundException;
import br.com.ciandt.playlist.entity.Music;
import br.com.ciandt.playlist.entity.Playlist;
import br.com.ciandt.playlist.repository.PlaylistRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    private static final Logger logger = LogManager.getLogger(PlaylistService.class);

    @Autowired
    private PlaylistRepo playlistRepo;
    @Autowired
    private MusicRepo musicRepo;

    public List<Playlist> userPlaylist(final String username) {
        logger.info("Retrieving playlists from user: " + username);
        return playlistRepo.findByUsuarioNomeIgnoreCase(username);
    }

    public void addMusicToPlaylist(final String playlistId, final Music paramMusic) throws NotFoundException {
        final Optional<Playlist> playlist = playlistRepo.findById(playlistId);
        final Optional<Music> music = musicRepo.findById(paramMusic.getId());

        if (!playlist.isPresent() || !music.isPresent()) {
            logger.info("Playlist or music not found");
            throw new NotFoundException("Playlist or music not found");
        }

        final Playlist p = playlist
                .get()
                .addMusic(music.get());

        playlistRepo.save(p);
    }
}
