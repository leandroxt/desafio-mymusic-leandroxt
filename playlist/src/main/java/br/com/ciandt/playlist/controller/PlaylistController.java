package br.com.ciandt.playlist.controller;

import br.com.ciandt.playlist.Exceptions.NotFoundException;
import br.com.ciandt.playlist.entity.Music;
import br.com.ciandt.playlist.entity.Playlist;
import br.com.ciandt.playlist.service.PlaylistService;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/playlists")
@Api(value = "APIs responsible to interact with user playlist")
public class PlaylistController {
    private static final Logger logger = LogManager.getLogger(PlaylistController.class);

    @Autowired
    private PlaylistService service;

    @RequestMapping(method = GET)
    public ResponseEntity<List<Playlist>> userPlaylist(@RequestParam("user") final String user) {
        logger.info("retrieve user playlist");
        if (user.length() < 3) {
            return new ResponseEntity<>(BAD_REQUEST);
        }

        final List<Playlist> list = service.userPlaylist(user);
        if (list.size() == 0) {
            return new ResponseEntity<>(list, NO_CONTENT);
        }
        return new ResponseEntity<>(list, OK);
    }

    @RequestMapping(method = PUT, path = "/{playlistId}/musicas")
    public ResponseEntity<?> addMusicToPlaylist(
            @PathVariable("playlistId") final String playlistId,
            @RequestBody final Music music
    ) {
        logger.info("adding music to playlist in playlistId: " + playlistId);

        try {
            service.addMusicToPlaylist(playlistId, music);
            return new ResponseEntity<>(OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        } catch (Error e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = DELETE, path = "/{playlistId}/musicas/{musicId}")
    public ResponseEntity<?> removeMusicFromPlaylist(
            @PathVariable("playlistId") final String playlistId,
            @PathVariable("musicId") final String musicId
    ) {
        logger.info("removing music from playlist in playlistId: " + playlistId);
        try {
            service.removeMusicFromPlaylist(playlistId, musicId);
            return new ResponseEntity<>(OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        } catch (Error e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }
}
