package org.internetStore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.internetStore.models.entities.Basket;
import org.internetStore.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/secured")
public class SecuredController {
    @Autowired
    private BasketService basketService;
    @GetMapping("/main")
    public ResponseEntity<String> getWorkedPage() {
        String messape = "Вы зашли в защищенный в Main!";
        log.info("Вы зашли в защищенный Main!");
        return ResponseEntity.ok(messape);
    }
    @GetMapping("/basket")
    public ResponseEntity<List<Basket>> getBasket() {
        return ResponseEntity.ok(basketService.getBasket());
    }
    @GetMapping("/basket/drop/{id}")
    public ResponseEntity dropProductFromBasket(@PathVariable("id") int id) {
        basketService.dropProductFromBasket(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/products/{id}/toBasket")
    public ResponseEntity addProductToBasket(@PathVariable("id") int id) {
        basketService.addProductToBasket(id);
        return ResponseEntity.ok().build();
    }
}
