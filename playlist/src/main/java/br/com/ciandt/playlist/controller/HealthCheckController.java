package br.com.ciandt.playlist.controller;

import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Api(value = "health check to know if server is up and running")
public class HealthCheckController {
    private static final Logger logger = LogManager.getLogger(HealthCheckController.class);

    @RequestMapping(method = GET, path = "/check")
    public String healthCheck() {
        logger.info("health check: OK");
        return "up and running";
    }
}
