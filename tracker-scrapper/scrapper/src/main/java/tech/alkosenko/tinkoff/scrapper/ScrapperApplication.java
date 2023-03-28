package tech.alkosenko.tinkoff.scrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import tech.alkosenko.tinkoff.scrapper.client.GitHubClient;
import tech.alkosenko.tinkoff.scrapper.configuration.ApplicationConfig;
import tech.alkosenko.tinkoff.scrapper.dto.response.GitHubRepositoryUpdateResponse;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
@ComponentScan("tech.alkosenko.tinkoff.scrapper.controller")
@ComponentScan("tech.alkosenko.tinkoff.scrapper.client")
public class ScrapperApplication {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(ScrapperApplication.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        GitHubClient gitHubClient = new GitHubClient("a1k0u", "tracker-scrapper");
        GitHubRepositoryUpdateResponse gitHubRepositoryUpdateResponse = gitHubClient.getRepositoryUpdate();
        System.out.println(gitHubRepositoryUpdateResponse.fullName() + " " + gitHubRepositoryUpdateResponse.updatedAt());
    }
}
