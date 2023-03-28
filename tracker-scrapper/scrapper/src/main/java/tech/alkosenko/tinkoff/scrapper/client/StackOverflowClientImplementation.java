package tech.alkosenko.tinkoff.scrapper.client;

import org.springframework.web.reactive.function.client.WebClient;
import tech.alkosenko.tinkoff.scrapper.dto.response.StackOverflowQsnUptResponse;

public class StackOverflowClientImplementation implements StackOverflowClient {
    private final WebClient webClient;
    private final String baseUrl;

    public StackOverflowClientImplementation(WebClient webClient, String baseUrl) {
        this.baseUrl = baseUrl;
        this.webClient = webClient;
    }

    @Override
    public StackOverflowQsnUptResponse fetchQuestion(String id) {
        return webClient.get()
                .uri(uriBuilder
                        -> uriBuilder.path(String.join("/", baseUrl, "questions", id))
                        .queryParam("site", "stackoveflow")
                        .build())
                .retrieve()
                .bodyToMono(StackOverflowQsnUptResponse.class)
                .block();
    }
}
