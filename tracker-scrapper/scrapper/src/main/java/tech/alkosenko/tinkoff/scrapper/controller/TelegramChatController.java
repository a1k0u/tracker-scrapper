package tech.alkosenko.tinkoff.scrapper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelegramChatController {
    @PostMapping("/tg-chat/{id}")
    public ResponseEntity<HttpStatus> registerTelegramChat(@PathVariable Integer id) {
        System.out.println(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/tg-chat/{id}")
    public ResponseEntity<HttpStatus> deleteTelegramChat(@PathVariable Integer id) {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
