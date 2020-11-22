package br.com.ciandt.music.controller;

import br.com.ciandt.music.entity.Music;
import br.com.ciandt.music.service.MusicService;
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
@RequestMapping(path = "/musicas")
public class MusicController {
    private static final Logger logger = LogManager.getLogger(MusicController.class);

    @Autowired
    private MusicService service;

    @RequestMapping(method = GET)
    public ResponseEntity<?> musicas(@RequestParam("filtro") final String filtro) {
        logger.info("Searching music with filter: " + filtro);
        if (filtro.length() < 3) {
            return new ResponseEntity<>(BAD_REQUEST);
        }

        final List<Music> musics = service.findMusic(filtro);
        if (musics.size() == 0) {
            return new ResponseEntity<>(musics, NO_CONTENT);
        }
        return new ResponseEntity<>(musics, OK);
    }
}
