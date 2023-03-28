package tech.alkosenko.tinkoff.scrapper.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LinkUpdaterScheduler {
    @Scheduled(fixedDelayString = "#{scheduleIntervalTimerValue}")
    public void update() {
        System.out.println("String from scheduler!");
    }
}
