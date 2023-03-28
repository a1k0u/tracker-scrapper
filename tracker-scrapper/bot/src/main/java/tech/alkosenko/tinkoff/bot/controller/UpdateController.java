package tech.alkosenko.tinkoff.bot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tech.alkosenko.tinkoff.bot.dto.request.BotUpdateRequest;

@RestController
public class UpdateController {
    @PostMapping("/updates")
    public ResponseEntity<HttpStatus> getUpdates(@RequestBody BotUpdateRequest botUpdateRequest) {
        System.out.println(botUpdateRequest.toString());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
