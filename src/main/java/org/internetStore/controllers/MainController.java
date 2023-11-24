package org.internetStore.controllers;

import lombok.extern.slf4j.Slf4j;
import org.internetStore.models.entities.productEntities.Product;
import org.internetStore.models.entities.warehouseEntities.Warehouse;
import org.internetStore.service.ProductService;
import org.internetStore.service.WarehouseService;
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
    @Autowired
    private WarehouseService warehouseService;
    @GetMapping
    public ResponseEntity<String> getWorkedPage() {
        String messape = "Вы зашли в Main!";
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
    @PostMapping("/products/new")
    public ResponseEntity newProduct(@RequestBody Product product) {
        productService.newProduct(product);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/products/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/products/drop/{id}")
    public ResponseEntity dropProduct(@PathVariable int id) {
        productService.dropProduct(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/warehouses")
    public ResponseEntity<List<Warehouse>> getWarehouseList() {
        return ResponseEntity.ok(warehouseService.getWarehouseList());
    }
    @GetMapping("/warehouses/{id}")
    public ResponseEntity<Warehouse> getWarehouse(@PathVariable int id) {
        return ResponseEntity.ok(warehouseService.getWarehouseByID(id));
    }
    @PostMapping("/warehouses/new")
    public ResponseEntity newWarehouse(@RequestBody Warehouse warehouse) {
        warehouseService.newWarehouse(warehouse);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/warehouses/update/{id}")
    public ResponseEntity updateWarehouse(@PathVariable int id, @RequestBody Warehouse warehouse) {
        warehouseService.updateWarehouse(id, warehouse);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/warehouses/drop/{id}")
    public ResponseEntity dropWarehouse(@PathVariable int id) {
        warehouseService.dropWarehouse(id);
        return ResponseEntity.ok().build();
    }
}
