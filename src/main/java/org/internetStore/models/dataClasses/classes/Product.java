package org.internetStore.models.dataClasses.classes;

import lombok.Data;
import org.internetStore.models.dataClasses.interfaces.Warehouse;
import org.internetStore.models.dataClasses.interfaces.productInterfaces.IProduct;

import java.util.Date;
import java.util.List;

@Data
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

    public Product(int productId, String productName, List<Warehouse> warehouses, int productCount, String companyName, double price, String productType, String country, Date announcementYear) {
        this.productId = productId;
        this.productName = productName;
        this.warehouses = warehouses;
        this.productCount = productCount;
        this.companyName = companyName;
        this.price = price;
        this.productType = productType;
        this.country = country;
        this.announcementYear = announcementYear;
    }

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
