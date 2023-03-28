package tech.alkosenko.tinkoff.scrapper.service;

import org.springframework.web.reactive.function.client.WebClient;
import tech.alkosenko.tinkoff.scrapper.dto.response.GitHubRepositoryUpdateResponse;

public class GitHubService {
    static public GitHubRepositoryUpdateResponse getUserGitHubRepositoryUpdate(
            String baseUrl, String userName, String repository) {
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        return webClient.get()
                .uri(String.join("/", baseUrl, "repos", userName, repository))
                .retrieve()
                .bodyToMono(GitHubRepositoryUpdateResponse.class)
                .block();
    }
}
