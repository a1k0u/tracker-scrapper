package tech.alkosenko.linkParser.services;

import tech.alkosenko.linkParser.services.objects.ParserChain;
import tech.alkosenko.linkParser.services.objects.ServiceData;
import tech.alkosenko.linkParser.services.objects.Id;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class StackOverflow extends ParserChain {

    @Override
    protected ServiceData getServiceData(URL url) {
        if (!url.getHost().equals("stackoverflow.com")) {
            return null;
        }

        String[] pathParts = url.getPath().split("/");

        if (pathParts.length < 3) {
            return null;
        }

        Map<String, String> serviceData = new HashMap<>();
        serviceData.put("id", pathParts[2]);

        return new ServiceData(Id.STACKOVERFLOW, serviceData);
    }
}
