package tech.alkosenko.linkParser;
import java.net.URL;
import tech.alkosenko.linkParser.services.records.ParsingResult;

public abstract class AbstractChainParser implements ChainParser {
    private final ChainParser next;

    public AbstractChainParser(ChainParser next) {
        this.next = next;
    }

    public ParsingResult parseInChain(URL url) {
        ParsingResult result = getServiceData(url);

        if (result != null) {
            return result;
        }

        return next != null ? next.parseInChain(url) : null;
    }
}
