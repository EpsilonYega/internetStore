package org.internetStore.models.entities.productEntities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.internetStore.models.entities.warehouseEntities.Warehouse;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public abstract class Product implements IProduct {
    private int productId;
    private String productName;
    private List<Warehouse> warehouses;
    private int productCount;
    private String companyName;
    private double price;
    private String productType;
    private String country;
    private Date announcementYear;

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public List<Warehouse> getProductPlacementList() {
        return warehouses;
    }

    @Override
    public int getProductCount() {
        return productCount;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public Date getAnnouncementYear() {
        return announcementYear;
    }
}
