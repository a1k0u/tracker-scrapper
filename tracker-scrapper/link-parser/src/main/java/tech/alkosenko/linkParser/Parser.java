package tech.alkosenko.linkParser;

import java.net.MalformedURLException;
import java.net.URL;
import tech.alkosenko.linkParser.services.GitHubParser;
import tech.alkosenko.linkParser.services.StackOverflowParser;
import tech.alkosenko.linkParser.services.data.ServiceData;

/*
 * To add parser for new service, you have to:
 *
 * - Add a new name to the enumeration ServiceId in the package `services.data`.
 * - Write the parser in the package `services`: `SomeSiteParser.java`,
 *   which extends `AbstractChainParser` and overrides `getServiceData`.
 * - Add it to the chain in the Parser.java to the static section.
 * - (Optional) Write `record` for the service in the package `services.records`.
 * - (Optional) Write a transformation of ServiceData into SomeSiteServiceData of
 *   the site in services.utils.TransformerServiceDataToRecord.
 * */

public class Parser {
    private static final AbstractChainParser parserChain;

    static {
        /*
         * Static parserChain.
         * Each new handler adding at the end of last.
         * */

        parserChain = new GitHubParser(new StackOverflowParser(null));
    }

    public static ServiceData parse(String stringifiedUrl) {
        /*
         * If some service is found in link, serviceData will return.
         * Otherwise, null.
         *
         * Service data can be transformed appropriate record.
         * ^ .services.util.TransformerServiceDataToRecord
         * */

        try {
            URL url = new URL(stringifiedUrl);
            return parserChain.parseInChain(url);
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
