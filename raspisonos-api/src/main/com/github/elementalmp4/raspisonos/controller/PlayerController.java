package main.com.github.elementalmp4.raspisonos.controller;

import main.com.github.elementalmp4.raspisonos.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player/pause-play")
    void pausePlay() {
        playerService.pausePlay();
    }

    @PostMapping("/player/next")
    void next() {
        playerService.next();
    }

    @PostMapping("/player/previous")
    void previous() {
        playerService.previous();
    }

    @PostMapping("/player/volume-up")
    void volumeUp() {
        playerService.volumeUp();
    }

    @PostMapping("/player/volume-down")
    void volumeDown() {
        playerService.volumeDown();
    }

}
