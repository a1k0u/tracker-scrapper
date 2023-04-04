package tech.alkosenko.tinkoff.scrapper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.alkosenko.tinkoff.scrapper.dto.request.LinkInfoRequest;
import tech.alkosenko.tinkoff.scrapper.dto.response.LinkInfoResponse;
import tech.alkosenko.tinkoff.scrapper.dto.response.ListOfTrackedLinksResponse;

@RestController
public class LinkController {
    @GetMapping("/links")
    public ResponseEntity<HttpStatus> getAllTrackedLinks(
            @RequestParam("tg-chat-id") Integer telegramChatId) {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/links")
    public ResponseEntity<HttpStatus> addNewTrackedLink(
            @RequestParam("tg-chat-id") Integer telegramChatId,
            @RequestBody LinkInfoRequest linkInfoRequest) {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/links")
    public ResponseEntity<HttpStatus> deleteTrackedLink(
            @RequestParam("tg-chat-id") Integer telegramChatId,
            @RequestBody LinkInfoRequest linkInfoRequest) {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
