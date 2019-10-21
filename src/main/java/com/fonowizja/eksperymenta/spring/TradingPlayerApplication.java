package com.fonowizja.eksperymenta.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Starting point of application.
 *
 * @author krzysztof.kramarz
 */
@SpringBootApplication
@PropertySource(value = "application.properties")
@EnableScheduling
public class TradingPlayerApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradingPlayerApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting application...");
        SpringApplication.run(TradingPlayerApplication.class, args);


    }
}


