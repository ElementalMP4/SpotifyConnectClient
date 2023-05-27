package main.com.github.elementalmp4.raspisonos.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Template {

    private String theTemplate;

    public Template(String path) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
        this.theTemplate = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

    public Template set(String key, String value) {
        this.theTemplate = this.theTemplate.replace("{{" + key + "}}", value);
        return this;
    }

    @Override
    public String toString() {
        return this.theTemplate;
    }

}
