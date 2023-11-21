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
    @Column(name = "productname")
    private String productname;
    @Column(name = "category")
    private String category;
    @ElementCollection
    @Column(name = "characteristicsList")
    private List<String> characteristicsList;
    private static int counter = 0;

    public Product(){}

    public Product(String productName, String category, List<String> characteristicsList) {
        this.productid = counter;
        this.productname = productName;
//        this.productPlacementList = productPlacementList;
        this.category = category;
        this.characteristicsList = characteristicsList;
        counter++;
    }
}
