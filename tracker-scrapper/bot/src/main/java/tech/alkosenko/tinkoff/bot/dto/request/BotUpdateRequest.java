package tech.alkosenko.tinkoff.bot.dto.request;

import java.util.List;

public class BotUpdateRequest {
    private int id;
    private String url;
    private String description;
    private List<Integer> tgChatIds;
}
