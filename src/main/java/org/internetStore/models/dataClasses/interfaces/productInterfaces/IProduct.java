package org.internetStore.models.dataClasses.interfaces.productInterfaces;


import org.internetStore.models.dataClasses.interfaces.Warehouse;

import java.util.Date;
import java.util.List;

public interface IProduct {
    public int getProductId();
    public String getProductName();
    public List<Warehouse> getProductPlacementList();
    public int getProductCount();
    public String getCompanyName();
    public double getPrice();
    public String getProductType();
    public String getCountry();
    public Date getAnnouncementYear();
}
