package org.internetStore.models.entities.warehouseEntities;

import org.internetStore.models.entities.productEntities.Product;

import java.util.List;

public interface IWarehouse {
    public String getWarehouseAddress();
    public List<Product> getAvailableProductsList();
    public void newProduct(Product p);
    public void dropProduct(int id);
    public void dropProduct(Product p);
}
