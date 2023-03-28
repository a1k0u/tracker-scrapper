package tech.alkosenko.tinkoff.scrapper.service;

import org.springframework.web.reactive.function.client.WebClient;
import tech.alkosenko.tinkoff.scrapper.client.GitHubClient;
import tech.alkosenko.tinkoff.scrapper.dto.response.GitHubRepoUptResponse;

public class GitHubService implements GitHubClient {
    private final WebClient webClient;

    private final String baseUrl;

    public GitHubService(WebClient webClient, String baseUrl) {
        this.baseUrl = baseUrl;
        this.webClient = webClient;
    }

    @Override
    public GitHubRepoUptResponse fetchRepository(String userName, String repository) {
        return webClient.get()
                .uri(String.join("/", baseUrl, "repos", userName, repository))
                .retrieve()
                .bodyToMono(GitHubRepoUptResponse.class)
                .block();
    }
}
