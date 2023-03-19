package tech.alkosenko.linkParser.services.objects;

import java.util.Map;

public class ServiceData {
    public Id id;
    public Map<String, String> serviceData;

    public ServiceData(Id id, Map<String, String> serviceData) {
        this.id = id;
        this.serviceData = serviceData;
    }
}
