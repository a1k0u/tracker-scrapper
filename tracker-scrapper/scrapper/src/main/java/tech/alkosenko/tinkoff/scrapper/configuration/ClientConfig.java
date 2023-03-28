package tech.alkosenko.tinkoff.scrapper.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;
import tech.alkosenko.tinkoff.scrapper.client.GitHubClient;
import tech.alkosenko.tinkoff.scrapper.service.GitHubService;
import tech.alkosenko.tinkoff.scrapper.client.StackOverflowClient;
import tech.alkosenko.tinkoff.scrapper.service.StackOverflowService;

import java.util.Optional;

@Configuration
public class ClientConfig {
    @Autowired
    private Environment environment;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("").build();
    }

    String getBaseUrl(Optional<String> userUrl, String baseUrlKey) {
        String url = environment.getProperty(baseUrlKey);

        if (userUrl.isPresent()) {
            url = userUrl.get();
        }

        return url;
    }

    @Bean
    GitHubClient gitHubClient(@Autowired WebClient webClient, Optional<String> userUrl) {
        return new GitHubService(webClient, getBaseUrl(userUrl, "api.github.link"));
    }

    @Bean
    StackOverflowClient stackOverflowClient(@Autowired WebClient webClient, Optional<String> userUrl) {
        return new StackOverflowService(webClient, getBaseUrl(userUrl, "api.stackoverflow.link"));
    }

}

