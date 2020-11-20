package br.com.ciandt.playlist.controller;

import br.com.ciandt.playlist.entity.Playlist;
import br.com.ciandt.playlist.service.PlaylistService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/playlists")
public class PlaylistController {
    private static final Logger logger = LogManager.getLogger(PlaylistController.class);

    @Autowired
    private PlaylistService service;

    @RequestMapping(method = GET)
    public ResponseEntity<List<Playlist>> userPlaylist(@RequestParam("user") String user) {
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
}
