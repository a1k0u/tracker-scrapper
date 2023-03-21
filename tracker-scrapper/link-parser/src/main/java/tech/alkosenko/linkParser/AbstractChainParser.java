package tech.alkosenko.linkParser;
import java.net.URL;
import tech.alkosenko.linkParser.services.records.ParsingResult;

public abstract class AbstractChainParser implements ChainParser {
    private final AbstractChainParser next;

    public AbstractChainParser(AbstractChainParser next) {
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
