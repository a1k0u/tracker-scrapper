package tech.alkosenko.linkParser;

import java.net.URL;
import tech.alkosenko.linkParser.services.records.ParsingResult;

public interface ChainParser {
    ParsingResult parseInChain(URL url);
    ParsingResult getServiceData(URL url);
}
