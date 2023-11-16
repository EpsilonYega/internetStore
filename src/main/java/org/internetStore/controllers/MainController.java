package org.internetStore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/main")
public class MainController {
    @GetMapping
    public ResponseEntity<String> getWorkedPage() {
        String messape = "Я тебе в душу срал, нахуй ты сюда зашел";
        log.info("Вы зашли в Main!");
        return ResponseEntity.ok(messape);
    }
}
