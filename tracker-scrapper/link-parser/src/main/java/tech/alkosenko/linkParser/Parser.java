package tech.alkosenko.linkParser;

import tech.alkosenko.linkParser.services.GitHub;
import tech.alkosenko.linkParser.services.StackOverflow;
import tech.alkosenko.linkParser.services.objects.ParserChain;
import tech.alkosenko.linkParser.services.objects.ServiceData;
import java.net.URL;
import java.net.MalformedURLException;
public class Parser {

    public ServiceData parse(String stringifiedUrl) {
        URL url;

        try {
            url = new URL(stringifiedUrl);
        } catch (MalformedURLException e) {
            return null;
        }

        ParserChain parserChain = new GitHub();
        parserChain.setNext(new StackOverflow());

        return parserChain.parse(url);
    }
}
