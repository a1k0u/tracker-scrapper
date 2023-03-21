package tech.alkosenko.linkParser;

import java.net.URL;
import tech.alkosenko.linkParser.services.data.ServiceData;

public interface ChainParser {
    ServiceData parseInChain(URL url);
    ServiceData getServiceData(URL url);
}
