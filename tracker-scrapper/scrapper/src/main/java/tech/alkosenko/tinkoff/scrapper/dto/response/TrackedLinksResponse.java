package tech.alkosenko.tinkoff.scrapper.dto.response;

import java.util.List;

class Link {
    private Integer id;
    private String url;
}

public class TrackedLinksResponse {
    private List<Link> links;
    private Integer id;
}
