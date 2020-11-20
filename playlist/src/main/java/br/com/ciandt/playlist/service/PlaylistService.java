package br.com.ciandt.playlist.service;

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

    public List<Playlist> userPlaylist(String username) {
        logger.info("Retrieving playlists from user: " + username);
        return playlistRepo.findByUserNameIgnoreCase(username);
    }

}
