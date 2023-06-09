package tech.alkosenko.linkParser;

import java.net.MalformedURLException;
import java.net.URL;
import tech.alkosenko.linkParser.services.GitHubParser;
import tech.alkosenko.linkParser.services.StackOverflowParser;
import tech.alkosenko.linkParser.services.records.ParsingResult;

/**
 * New parser instruction.
 * - Release parser in package `services`: `SomeSiteParser.java`
 * - Release record for service data in `services.records`.
 * - Than this record have to permit from ParsingResult sealed interface.
 * - Add parser in the chain.
 */
public class Parser {
    /**
     * Static parserChain.
     * Each new handler adding at the end of last.
     */
    private static final ChainParser parserChain = new GitHubParser(new StackOverflowParser(null));


    /**
     * If some service is found in link, serviceData will return.
     * Otherwise, null.
     */
    public static ParsingResult parse(String stringifiedUrl) {
        try {
            URL url = new URL(stringifiedUrl);
            return parserChain.parseInChain(url);
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
