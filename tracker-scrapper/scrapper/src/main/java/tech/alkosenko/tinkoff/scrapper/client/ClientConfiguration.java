package tech.alkosenko.tinkoff.scrapper.client;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import tech.alkosenko.tinkoff.scrapper.service.GitHubService;

import java.util.Optional;

@Configuration
public class ClientConfiguration {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    GitHubClient gitHubClient(String userName, String repository, Optional<String> url) {
        GitHubClient gitHubClient = new GitHubClient(userName, repository);

        if (url.isPresent()) {
            gitHubClient.setBaseUrl(String.valueOf(url));
        }

        return gitHubClient;
    }
}

