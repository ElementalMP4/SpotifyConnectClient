package main.com.github.elementalmp4.raspisonos.service;

import main.com.github.elementalmp4.raspisonos.utils.Template;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class SetupService {

    private static final String WIFI_CONFIG_FILE_PATH = "/etc/wpa_supplicant/wpa_supplicant.conf";

    public void setupWifi(String ssid, String psk) {
        Template wifiTemplate = new Template("wifi-config.tmpl");
        String config = wifiTemplate.set("SSID", ssid).set("PASSWORD", psk).toString();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(WIFI_CONFIG_FILE_PATH));
            writer.write(config);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
