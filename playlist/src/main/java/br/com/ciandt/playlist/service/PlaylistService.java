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
        final Playlist playlist = playlistRepo.findById(playlistId)
                .orElseThrow(() -> new NotFoundException("playlist_not_found"));
        final Music music = musicRepo.findById(paramMusic.getId())
                .orElseThrow(() -> new NotFoundException("music_not_found"));

        if (playlist.contains(music)) {
            // playlist already have this music then no need to continue
            return;
        }

        final Playlist p = playlist
                .addMusic(music);

        playlistRepo.save(p);
    }

    public void removeMusicFromPlaylist(final String playlistId, final String musicId) throws NotFoundException {
        final Playlist playlist = playlistRepo.findById(playlistId)
                .orElseThrow(() -> new NotFoundException("playlist_not_found"));
        final Music music = musicRepo.findById(musicId)
                .orElseThrow(() -> new NotFoundException("music_not_found"));

        if (!playlist.contains(music)) {
            // no need to continue cause music does not exists in the list
            return;
        }

        final Playlist p = playlist
                .removeMusic(music);

        playlistRepo.save(p);
    }
}
