package tech.alkosenko.linkParser.services;

import java.net.URL;
import tech.alkosenko.linkParser.AbstractChainParser;
import tech.alkosenko.linkParser.services.records.ParsingResult;
import tech.alkosenko.linkParser.services.records.StackOverflowServiceData;

public class StackOverflowParser extends AbstractChainParser {
    public StackOverflowParser(AbstractChainParser next) {
        super(next);
    }

    @Override
    public ParsingResult getServiceData(URL url) {
        if (!url.getHost().equals("stackoverflow.com")) {
            return null;
        }

        String[] pathParts = url.getPath().split("/");

        if (pathParts.length < 3) {
            return null;
        }

        return new StackOverflowServiceData(pathParts[2]);
    }
}
