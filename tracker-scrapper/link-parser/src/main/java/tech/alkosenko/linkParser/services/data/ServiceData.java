package tech.alkosenko.linkParser.services.data;

import java.util.Map;

public record ServiceData(ServiceId serviceId, Map<String, String> serviceData) {}
