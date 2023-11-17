package org.internetStore.models.dataClasses.interfaces.productInterfaces;


import org.internetStore.models.dataClasses.interfaces.Warehouse;

import java.util.List;

public interface Product {
    public int getProductId();
    public String getProductName();
    public List<Warehouse> getProductPlacementList();
    public int getProductCount();
    public String getCompanyName();
}
