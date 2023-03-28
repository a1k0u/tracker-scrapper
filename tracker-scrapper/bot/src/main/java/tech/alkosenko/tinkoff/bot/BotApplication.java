package tech.alkosenko.tinkoff.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import tech.alkosenko.tinkoff.bot.configuration.ApplicationConfig;
import tech.alkosenko.tinkoff.scrapper.ScrapperApplication;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
@ComponentScan("tech.alkosenko.tinkoff.bot.controller")
public class BotApplication {
public static void main(String[] args) {
        var ctx = SpringApplication.run(BotApplication.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        System.out.println(config);
    }
}