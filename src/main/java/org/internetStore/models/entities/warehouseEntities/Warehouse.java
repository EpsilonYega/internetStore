package org.internetStore.models.entities.warehouseEntities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.internetStore.models.entities.productEntities.Product;

import java.util.List;

@Data
@AllArgsConstructor
public class Warehouse implements IWarehouse{
    private String warehouseAddress;
    private List<Product> availableProductsList;
    @Override
    public void newProduct(Product p) {
        availableProductsList.add(p);
    }

    @Override
    public void dropProduct(int id) {
        availableProductsList.remove(id);
    }

    @Override
    public void dropProduct(Product p) {
        availableProductsList.remove(p);
    }
}
