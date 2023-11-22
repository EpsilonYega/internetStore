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
@RequestMapping("/main")
public class MainController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<String> getWorkedPage() {
        String messape = "Я тебе в душу срал, нахуй ты сюда зашел";
        log.info("Вы зашли в Main!");
        return ResponseEntity.ok(messape);
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductList() {
        return ResponseEntity.ok(productService.getProductList());
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductByID(id));
    }
//    @GetMapping("/products/new")
//    public void newProduct() {
//        productService.newProduct();
//    }
    @PostMapping("/products/new")
    public ResponseEntity newProduct(@RequestBody Product product) {
        productService.newProduct(product);
        return ResponseEntity.ok().build();
    }
//    @GetMapping("/products/update/{id}")
//    public void updateProduct(@PathVariable int id) {
//        productService.updateProduct(id);
//    }
    @PatchMapping("/products/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return ResponseEntity.ok().build();
    }
//    @GetMapping("/products/drop/{id}")
//    public void dropProduct(@PathVariable int id) {
//        productService.dropProduct(id);
//    }
    @DeleteMapping("/products/drop/{id}")
    public ResponseEntity dropProduct(@PathVariable int id) {
        productService.dropProduct(id);
        return ResponseEntity.ok().build();
    }
}
