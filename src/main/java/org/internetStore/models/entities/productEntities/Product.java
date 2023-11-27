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

//    private String warehouseAddress;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
    private int warehouseId;
    private String warehouseAddress = "";

    public Product(){}

    public Product(String productName, String category, List<String> characteristicsList, Warehouse warehouse) {
        this.productname = productName;
        this.category = category;
        this.characteristicsList = characteristicsList;
        this.warehouse = warehouse;
    }
}
