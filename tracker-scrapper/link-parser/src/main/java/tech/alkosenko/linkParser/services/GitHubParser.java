package tech.alkosenko.linkParser.services;

import java.net.URL;

import tech.alkosenko.linkParser.AbstractChainParser;
import tech.alkosenko.linkParser.services.records.GitHubServiceData;
import tech.alkosenko.linkParser.services.records.ParsingResult;

public class GitHubParser extends AbstractChainParser {
    public GitHubParser(AbstractChainParser next) {
        super(next);
    }

    @Override
    public ParsingResult getServiceData(URL url) {
        if (!url.getHost().equals("github.com")) {
            return null;
        }

        System.out.println(url.getPath());
        String[] pathParts = url.getPath().split("/");

        if (pathParts.length < 3) {
            return null;
        }

        return new GitHubServiceData(pathParts[1], pathParts[2]);
    }
}
