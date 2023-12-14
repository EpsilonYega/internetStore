package org.internetStore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.internetStore.models.entities.productEntities.Product;
import org.internetStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {
    @Autowired
    private ProductService productService;
    @GetMapping("/main")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> getWorkedPage() {
        String messape = "Вы зашли в Main!";
        log.info("Вы зашли в Main!");
        return ResponseEntity.ok(messape);
    }
    @GetMapping("/products")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Product>> getProductList() {
        return ResponseEntity.ok(productService.getProductList());
    }
    @GetMapping("/products/search/{query}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Product>> getProductByQuery(@PathVariable("query") String searchQuery) {
        return ResponseEntity.ok(productService.getProductListByQuery(searchQuery));
    }
    @GetMapping("/products/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        return ResponseEntity.ok(productService.getProductByID(id));
    }
}
