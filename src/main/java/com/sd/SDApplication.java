package com.sd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Collections;

@ServletComponentScan
@SpringBootApplication
public class SDApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SDApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
        app.run(args);
    }
}
