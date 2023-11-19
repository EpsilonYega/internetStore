package org.internetStore.models.entities.productEntities;

import lombok.Data;
import org.internetStore.models.entities.warehouseEntities.Warehouse;

import java.util.List;

@Data
public class Product implements IProduct {
    private static int counter = 0;
    private int productId;
    private String productName;
//    private List<Warehouse> productPlacementList;
    private String category;
    private List<String> characteristicsList;
    public Product(){}

    public Product(String productName, String category, List<String> characteristicsList) {
        this.productId = counter;
        this.productName = productName;
//        this.productPlacementList = productPlacementList;
        this.category = category;
        this.characteristicsList = characteristicsList;
        counter++;
    }
}
