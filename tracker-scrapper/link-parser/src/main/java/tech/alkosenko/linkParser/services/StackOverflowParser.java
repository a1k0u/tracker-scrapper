package tech.alkosenko.linkParser.services;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import tech.alkosenko.linkParser.AbstractChainParser;
import tech.alkosenko.linkParser.services.data.ServiceData;
import tech.alkosenko.linkParser.services.data.ServiceId;

public class StackOverflowParser extends AbstractChainParser {
    public StackOverflowParser(AbstractChainParser next) {
        super(next);
    }

    @Override
    public ServiceData getServiceData(URL url) {
        if (!url.getHost().equals("stackoverflow.com")) {
            return null;
        }

        String[] pathParts = url.getPath().split("/");

        if (pathParts.length < 3) {
            return null;
        }

        Map<String, String> serviceData = new HashMap<>();
        serviceData.put("id", pathParts[2]);

        return new ServiceData(ServiceId.STACKOVERFLOW, serviceData);
    }
}
