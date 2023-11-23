package org.internetStore.models.entities.productEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.internetStore.models.entities.warehouseEntities.Warehouse;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

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
    @CollectionTable(name="Product_Characteristics", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "characteristicsList")
    private List<String> characteristicsList;
    @JsonIgnore
    @ManyToMany
    private List<Warehouse> warehouseList;
    @ElementCollection
    private List<Integer> warehouseIdList;
    @ElementCollection
    private List<String> warehouseAddressList = new ArrayList<>();

    public Product(){}

    public Product(String productName, String category, List<String> characteristicsList, List<Warehouse> warehouseList) {
        this.productname = productName;
        this.category = category;
        this.characteristicsList = characteristicsList;
        this.warehouseList = warehouseList;
    }
}
