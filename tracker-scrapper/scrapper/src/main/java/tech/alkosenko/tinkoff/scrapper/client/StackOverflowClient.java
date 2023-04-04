package tech.alkosenko.tinkoff.scrapper.client;

import tech.alkosenko.tinkoff.scrapper.dto.response.StackOverflowQsnUptResponse;

public interface StackOverflowClient {
    StackOverflowQsnUptResponse fetchQuestion(String id);
}
