package tech.alkosenko.linkParser;
import java.net.URL;
import tech.alkosenko.linkParser.services.data.ServiceData;

public abstract class AbstractChainParser implements ChainParser {
    private final AbstractChainParser next;

    public AbstractChainParser(AbstractChainParser next) {
        this.next = next;
    }

    public ServiceData parseInChain(URL url) {
        ServiceData result = getServiceData(url);

        if (result != null) {
            return result;
        }

        return next != null ? next.parseInChain(url) : null;
    }
}
