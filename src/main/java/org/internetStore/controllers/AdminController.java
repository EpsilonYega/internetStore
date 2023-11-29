package org.internetStore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.internetStore.Main;
import org.internetStore.models.entities.productEntities.Product;
import org.internetStore.models.entities.warehouseEntities.Warehouse;
import org.internetStore.service.ProductService;
import org.internetStore.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseService warehouseService;
    @GetMapping("/adminPage")
    public String userAccess(Principal principal){
        if (principal == null)
            return null;
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin"))
            return principal.getName();
        return "Вам сюда нельзя!";
    }
    @PostMapping("/products/new")
    public ResponseEntity newProduct(@RequestBody Product product) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            productService.newProduct(product);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @PatchMapping("/products/update/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            productService.updateProduct(id, product);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/products/drop/{id}")
    public ResponseEntity dropProduct(@PathVariable("id") long id) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            productService.dropProduct(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/warehouses")
    public ResponseEntity<List<Warehouse>> getWarehouseList() {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin"))
            return ResponseEntity.ok(warehouseService.getWarehouseList());
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/warehouses/{id}")
    public ResponseEntity<Warehouse> getWarehouse(@PathVariable("id") long id) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin"))
            return ResponseEntity.ok(warehouseService.getWarehouseByID(id));
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/warehouses/new")
    public ResponseEntity newWarehouse(@RequestBody Warehouse warehouse) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            warehouseService.newWarehouse(warehouse);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @PatchMapping("/warehouses/update/{id}")
    public ResponseEntity updateWarehouse(@PathVariable("id") long id, @RequestBody Warehouse warehouse) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            warehouseService.updateWarehouse(id, warehouse);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/warehouses/drop/{id}")
    public ResponseEntity dropWarehouse(@PathVariable("id") long id) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            warehouseService.dropWarehouse(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
