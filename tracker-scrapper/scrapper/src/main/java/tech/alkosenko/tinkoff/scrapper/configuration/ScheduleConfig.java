package tech.alkosenko.tinkoff.scrapper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleConfig {
    @Bean
    public long scheduleIntervalTimerValue(ApplicationConfig config) {
        return config.scheduled().interval().toMillis();
    }
}
