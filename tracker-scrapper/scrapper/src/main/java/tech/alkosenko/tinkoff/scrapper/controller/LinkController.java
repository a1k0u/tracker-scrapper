package tech.alkosenko.tinkoff.scrapper.controller;

import org.springframework.web.bind.annotation.*;
import tech.alkosenko.tinkoff.scrapper.dto.request.LinkInfoRequest;
import tech.alkosenko.tinkoff.scrapper.dto.response.LinkInfoResponse;
import tech.alkosenko.tinkoff.scrapper.dto.response.ListOfTrackedLinksResponse;

@RestController
public class LinkController {
    @GetMapping("/links")
    public ListOfTrackedLinksResponse getAllTrackedLinks(
            @RequestParam("tg-chat-id") Integer telegramChatId) {
        return new ListOfTrackedLinksResponse();
    }

    @PostMapping("/links")
    public LinkInfoResponse addNewTrackedLink(
            @RequestParam("tg-chat-id") Integer telegramChatId,
            @RequestBody LinkInfoRequest linkInfoRequest) {
        return new LinkInfoResponse();
    }

    @DeleteMapping("/links")
    public LinkInfoResponse deleteTrackedLink(
            @RequestParam("tg-chat-id") Integer telegramChatId,
            @RequestBody LinkInfoRequest linkInfoRequest) {
        return new LinkInfoResponse();
    }
}
