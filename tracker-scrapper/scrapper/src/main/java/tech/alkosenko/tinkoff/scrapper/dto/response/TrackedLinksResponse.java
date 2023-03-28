package tech.alkosenko.tinkoff.scrapper.dto.response;

import java.util.ArrayList;

class Link {
    private Integer id;
    private String url;
}

public class TrackedLinksResponse {
    private ArrayList<Link> links;
    private Integer id;
}
