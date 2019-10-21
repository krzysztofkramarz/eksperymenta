package com.fonowizja.eksperymenta.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

//   metoda startTrader startuje najpier wywołana  poprzez adnotację @PostConstruct raz,
//   a potem cron co 10 sekund wywołuje metodę
//   gdy  @PostConstruct wywoła się tuż przed sekunda nr co 10-tą to to pierwsze wywołanie nie zajdzie
@Component
@EnableScheduling
public class TraderManager {


    private static final Logger LOGGER = LoggerFactory.getLogger(TraderManager.class);

    @Value("${trader.start.cron}")
    String cron;

    @Autowired
    TraderManager() {
        System.out.println("KONSTRUKTOR");
    }

    @PostConstruct
    public void onStartup() {
        System.out.println(" @PostConstruct");
        System.out.println("cron jest ustawiony na" + cron);
        startTrader();
    }

    @Scheduled(cron = "${trader.start.cron}")
    public void startTrader() {

        System.out.println("computation");
        System.out.println(LocalDateTime.now().get(ChronoField.SECOND_OF_MINUTE));
    }
}






