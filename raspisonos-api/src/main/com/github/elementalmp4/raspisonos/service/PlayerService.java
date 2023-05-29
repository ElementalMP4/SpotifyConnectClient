package main.com.github.elementalmp4.raspisonos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private HttpClientService httpClientService;

    private static final String LIBRESPOT_URL = "http://localhost:24879/";

    public void pausePlay() {
        httpClientService.post(LIBRESPOT_URL + "player/pause-play");
    }

    public void next() {
        httpClientService.post(LIBRESPOT_URL + "player/next");
    }

    public void previous() {
        httpClientService.post(LIBRESPOT_URL + "player/prev");
    }

    public void volumeUp() {
        httpClientService.post(LIBRESPOT_URL + "player/volume-up");
    }

    public void volumeDown() {
        httpClientService.post(LIBRESPOT_URL + "player/volume-down");
    }

}
