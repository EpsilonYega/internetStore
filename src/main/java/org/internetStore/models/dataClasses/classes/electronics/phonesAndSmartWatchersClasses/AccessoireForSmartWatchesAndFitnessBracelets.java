package org.internetStore.models.dataClasses.classes.electronics.phonesAndSmartWatchersClasses;

import org.internetStore.models.dataClasses.classes.Product;
import org.internetStore.models.dataClasses.interfaces.Warehouse;
import org.internetStore.models.dataClasses.interfaces.productInterfaces.electronicsInterfaces.Electronics;

import java.util.Date;
import java.util.List;

public abstract class AccessoireForSmartWatchesAndFitnessBracelets extends Product implements Electronics {
    private String deviceModel;

    public AccessoireForSmartWatchesAndFitnessBracelets(int productId, String productName, List<Warehouse> warehouses, int productCount, String companyName, double price, String productType, String country, Date announcementYear, String deviceModel) {
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
