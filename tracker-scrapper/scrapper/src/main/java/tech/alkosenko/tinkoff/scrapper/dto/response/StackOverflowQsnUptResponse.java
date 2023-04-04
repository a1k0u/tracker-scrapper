package tech.alkosenko.tinkoff.scrapper.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record StackOverflowQsnUptResponse(
        @JsonProperty("title") String title,
        @JsonProperty("last_activity_date") OffsetDateTime updatedAt) {
}
