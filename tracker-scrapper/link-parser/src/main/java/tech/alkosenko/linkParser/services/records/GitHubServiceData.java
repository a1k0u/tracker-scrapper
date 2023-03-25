package tech.alkosenko.linkParser.services.records;

public record GitHubServiceData(String userName, String repositoryName) implements ParsingResult {}
