package tech.alkosenko.tinkoff.scrapper.client;

import tech.alkosenko.tinkoff.scrapper.dto.response.GitHubRepositoryUpdateResponse;
import tech.alkosenko.tinkoff.scrapper.service.GitHubService;

public class GitHubClient {
    private final String userName;
    private final String repository;
    private String baseUrl = "https://api.github.com";

    public GitHubClient(String userName, String repository) {
        this.userName = userName;
        this.repository = repository;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public GitHubRepositoryUpdateResponse getRepositoryUpdate() {
        System.out.println(baseUrl + " @ " + userName + " @ " + repository);
        return GitHubService.getUserGitHubRepositoryUpdate(baseUrl, userName, repository);
    }
}
