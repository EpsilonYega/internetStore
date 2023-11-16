package org.internetStore.models.dataClasses;


import java.util.List;

public interface Product {
    public int getProductId();
    public String getProductName();
    public List<Warehouse> getProductPlacementList();
    public int getProductCount();
}
