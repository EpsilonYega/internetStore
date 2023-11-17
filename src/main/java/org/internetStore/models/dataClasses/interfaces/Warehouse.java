package org.internetStore.models.dataClasses.interfaces;

import org.internetStore.models.dataClasses.interfaces.productInterfaces.Product;

import java.util.List;

public interface Warehouse {
    public String getWarehouseAddress();
    public List<Product> getAvailableProductsList();
    public List<Product> newProduct(Product p);
    public List<Product> dropProduct(int id);
    public List<Product> dropProduct(Product p);
}
