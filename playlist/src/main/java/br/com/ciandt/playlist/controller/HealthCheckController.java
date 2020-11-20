package br.com.ciandt.playlist.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    private static final Logger logger = LogManager.getLogger(HealthCheckController.class);

    @RequestMapping
    public String healthCheck() {
        logger.info("health check: OK");
        return "up and running";
    }
}
