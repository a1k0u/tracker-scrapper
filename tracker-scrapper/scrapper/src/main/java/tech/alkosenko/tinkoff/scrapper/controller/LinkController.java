package tech.alkosenko.tinkoff.scrapper.controller;

import org.springframework.web.bind.annotation.*;
import tech.alkosenko.tinkoff.scrapper.dto.request.LinkRequest;
import tech.alkosenko.tinkoff.scrapper.dto.response.LinkResponse;
import tech.alkosenko.tinkoff.scrapper.dto.response.TrackedLinksResponse;

@RestController
public class LinkController {
    @GetMapping("/links")
    public TrackedLinksResponse getAllTrackedLinks(@RequestParam("tg-chat-id") Integer telegramChatId) {
        System.out.println(telegramChatId);
        return new TrackedLinksResponse();
    }

    @PostMapping("/links")
    public LinkResponse addNewTrackedLink(
            @RequestParam("tg-chat-id") Integer telegramChatId,
            @RequestBody LinkRequest linkRequest) {
        System.out.println(telegramChatId);
        System.out.println(linkRequest);
        return new LinkResponse();
    }

    @DeleteMapping("/links")
    public LinkResponse deleteTrackedLink(
            @RequestParam("tg-chat-id") Integer telegramChatId,
            @RequestBody LinkRequest linkRequest) {
        System.out.println(telegramChatId);
        System.out.println(linkRequest);
        return new LinkResponse();
    }
}
