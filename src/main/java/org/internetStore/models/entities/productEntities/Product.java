package org.internetStore.models.entities.productEntities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "product", schema = "public", catalog = "internet_store_db")
public class Product implements IProduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int productid;
    private String productname;
    private String category;
    private String characteristicsList;
    private static int counter = 0;

    public Product(){}

    public Product(String productName, String category, String characteristicsList) {
        this.productid = counter;
        this.productname = productName;
//        this.productPlacementList = productPlacementList;
        this.category = category;
        this.characteristicsList = characteristicsList;
        counter++;
    }
}
