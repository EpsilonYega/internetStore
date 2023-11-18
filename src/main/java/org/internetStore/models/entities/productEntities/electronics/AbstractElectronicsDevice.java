package org.internetStore.models.entities.productEntities.electronics;

import org.internetStore.models.entities.productEntities.Product;
import org.internetStore.models.entities.warehouseEntities.Warehouse;

import java.util.Date;
import java.util.List;

public class AbstractElectronicsDevice extends Product implements Electronics{
    private String deviceModel;
    public AbstractElectronicsDevice(int productId, String productName, List<Warehouse> warehouses, int productCount, String companyName, double price, String productType, String country, Date announcementYear, String deviceModel) {
        super(productId, productName, warehouses, productCount, companyName, price, productType, country, announcementYear);
        setDeviceModel(deviceModel);
    }
    @Override
    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }
}
