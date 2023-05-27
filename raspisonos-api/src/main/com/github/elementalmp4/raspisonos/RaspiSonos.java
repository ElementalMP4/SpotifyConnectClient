package main.com.github.elementalmp4.raspisonos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class RaspiSonos {

    public static void main(final String[] args) {
        SpringApplication springApp = new SpringApplication(RaspiSonos.class);
        Properties props = new Properties();
        props.setProperty("server.port", "80");
        springApp.setDefaultProperties(props);
        springApp.run(args);
    }
}