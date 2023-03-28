package tech.alkosenko.tinkoff.scrapper.client;

import tech.alkosenko.tinkoff.scrapper.dto.response.GitHubRepoUptResponse;

public interface GitHubClient {
    GitHubRepoUptResponse fetchRepository(String userName, String repository);
}
