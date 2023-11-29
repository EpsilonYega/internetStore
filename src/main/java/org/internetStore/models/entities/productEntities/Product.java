package org.internetStore.models.entities.productEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.internetStore.Main;
import org.internetStore.dal.DataAccessLayer;
import org.internetStore.models.entities.Basket;
import org.internetStore.models.entities.User;
import org.internetStore.models.entities.warehouseEntities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "product", schema = "public", catalog = "internet_store_db")
public class Product implements IProduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long productid;
    @Column(name = "productname")
    private String productname;
    @Column(name = "category")
    private String category;
    @ElementCollection
    @CollectionTable(name="Product_Characteristics", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "characteristicsList")
    private List<String> characteristicsList;
    @Column
    private double price;

//    private String warehouseAddress;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
    private int warehouseId;
    private String warehouseAddress = "";

    public Product(){}

    public Product(String productName, String category, List<String> characteristicsList, Warehouse warehouse, double price) {
        this.productname = productName;
        this.category = category;
        this.characteristicsList = characteristicsList;
        this.warehouse = warehouse;
        this.price = price;
    }
    public Basket addProductToBasket(){
        return new Basket(Main.currentUser, this, this.getProductname(), this.getPrice());
    }
}
