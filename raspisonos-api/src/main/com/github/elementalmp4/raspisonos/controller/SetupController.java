package main.com.github.elementalmp4.raspisonos.controller;

import main.com.github.elementalmp4.raspisonos.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetupController {

    @Autowired
    private SetupService setupService;

    @PostMapping("/setup/wifi")
    void setupWifi(@RequestParam String ssid, @RequestParam String psk) {
        setupService.setupWifi(ssid, psk);
    }

    @PostMapping("/setup/spotify")
    void setupSpotify(@RequestParam String email, @RequestParam String password) {
        setupService.setupSpotify(email, password);
    }

    @PostMapping("/setup/reboot")
    void reboot() {
        setupService.reboot();
    }

    @PostMapping("/setup/shutdown")
    void shutdown() {
        setupService.shutdown();
    }
}
