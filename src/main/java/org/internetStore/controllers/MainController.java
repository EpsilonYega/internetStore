package org.internetStore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.internetStore.models.entities.productEntities.Product;
import org.internetStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/products/new")
    public void newProduct() {
        productService.newProduct();
    }
//    @GetMapping("/products/new")
//    public ResponseEntity<Product> newProduct() {
//        return ResponseEntity.ok(productService.newProduct());
//    }
    @GetMapping("/products/update/{id}")
    public void updateProduct(@PathVariable int id) {
        productService.updateProduct(id);
    }
//    @GetMapping("/products/update")
//    public ResponseEntity<Product> updateProduct(@PathVariable int id) {
//        return ResponseEntity.ok(productService.updateProduct(id));
//    }
    @GetMapping("/products/drop/{id}")
    public void dropProduct(@PathVariable int id) {
        productService.dropProduct(id);
    }
//    @GetMapping("/products/drop")
//    public ResponseEntity<Product> dropProduct(@PathVariable int id) {
//        return ResponseEntity.ok(productService.dropProduct(id));
//    }
}
