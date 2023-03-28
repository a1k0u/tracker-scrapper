package tech.alkosenko.tinkoff.scrapper.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;
import tech.alkosenko.tinkoff.scrapper.client.GitHubClient;
import tech.alkosenko.tinkoff.scrapper.client.GitHubClientImplementation;
import tech.alkosenko.tinkoff.scrapper.client.StackOverflowClient;
import tech.alkosenko.tinkoff.scrapper.client.StackOverflowClientImplementation;

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
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    GitHubClient gitHubClient(@Autowired WebClient webClient, Optional<String> userUrl) {
        return new GitHubClientImplementation(webClient, getBaseUrl(userUrl, "api.github.link"));
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    StackOverflowClient stackOverflowClient(@Autowired WebClient webClient, Optional<String> userUrl) {
        return new StackOverflowClientImplementation(webClient, getBaseUrl(userUrl, "api.stackoverflow.link"));
    }

}

