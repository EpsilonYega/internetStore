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
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseService warehouseService;
    @GetMapping("/adminPage")
    @CrossOrigin(origins = "http://localhost:3000")
    public String userAccess(Principal principal){
        if (principal == null)
            return null;
        // TODO: 02.12.2023 Исправить  
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin"))
            return principal.getName();
        return "Вам сюда нельзя!";
    }
    @PostMapping("/products/new")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity newProduct(@RequestBody Product product) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            productService.newProduct(product);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/products/update/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            productService.updateProduct(id, product);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/products/drop/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity dropProduct(@PathVariable("id") long id) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            productService.dropProduct(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/warehouses")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Warehouse>> getWarehouseList() {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin"))
            return ResponseEntity.ok(warehouseService.getWarehouseList());
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/warehouses/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Warehouse> getWarehouse(@PathVariable("id") long id) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin"))
            return ResponseEntity.ok(warehouseService.getWarehouseByID(id));
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/warehouses/new")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity newWarehouse(@RequestBody Warehouse warehouse) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            warehouseService.newWarehouse(warehouse);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/warehouses/update/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity updateWarehouse(@PathVariable("id") long id, @RequestBody Warehouse warehouse) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            warehouseService.updateWarehouse(id, warehouse);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/warehouses/drop/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity dropWarehouse(@PathVariable("id") long id) {
        if (Objects.equals(Main.currentUser.getUsername(), "admin") && Objects.equals(Main.currentUser.getEmail(), "admin@sorokastore.ru") && Objects.equals(Main.currentUser.getPassword(), "admin")) {
            warehouseService.dropWarehouse(id);
            log.info("Вы успешно удалили склад");
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
