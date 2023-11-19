package org.internetStore.models.entities.productEntities;

import org.internetStore.models.entities.warehouseEntities.Warehouse;

import java.util.List;

public interface IProduct {
    public int getProductId();
    public String getProductName();
//    public List<Warehouse> getProductPlacementList();
    public String getCategory();

    public List<String> getCharacteristicsList();
}
