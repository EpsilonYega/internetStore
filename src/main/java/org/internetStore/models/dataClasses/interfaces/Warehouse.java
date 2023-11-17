package org.internetStore.models.dataClasses.interfaces;

import org.internetStore.models.dataClasses.interfaces.productInterfaces.IProduct;

import java.util.List;

public interface Warehouse {
    public String getWarehouseAddress();
    public List<IProduct> getAvailableProductsList();
    public List<IProduct> newProduct(IProduct p);
    public List<IProduct> dropProduct(int id);
    public List<IProduct> dropProduct(IProduct p);
}
