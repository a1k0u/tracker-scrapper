package tech.alkosenko.linkParser.services.utils;

import java.util.Map;
import tech.alkosenko.linkParser.services.data.ServiceData;
import tech.alkosenko.linkParser.services.records.GitHubServiceData;
import tech.alkosenko.linkParser.services.records.StackOverflowServiceData;

public class TransformerServiceDataToRecord {
    public static GitHubServiceData transformServiceToGitHub(
            ServiceData serviceData) {
        Map<String, String> mapData = serviceData.serviceData();
        return new GitHubServiceData(
                mapData.get("id"), mapData.get("repository"));
    }

    public static StackOverflowServiceData transformServiceToStackOverflow(
            ServiceData serviceData) {
        Map<String, String> mapData = serviceData.serviceData();
        return new StackOverflowServiceData(mapData.get("id"));
    }
}
