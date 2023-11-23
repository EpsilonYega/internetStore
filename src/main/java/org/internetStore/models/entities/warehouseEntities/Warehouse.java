package org.internetStore.models.entities.warehouseEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.internetStore.models.entities.productEntities.Product;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "warehouse", schema = "public", catalog = "internet_store_db")
public class Warehouse implements IWarehouse{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int warehouseId;
    @Column(name = "warehouseAddress")
    private String warehouseAddress;
    @JsonIgnore
    @ManyToMany(mappedBy = "warehouseList")
    private List<Product> availableProductsList;
    @ElementCollection
    private List<Integer> productIdList;
    @ElementCollection
    private List<String> productNameList = new ArrayList<>();
    public Warehouse(){}
    public Warehouse(String warehouseAddress, List<Product> availableProductsList) {
        this.warehouseAddress = warehouseAddress;
        this.availableProductsList = availableProductsList;
    }

    @Override
    public void newProduct(Product p) {
        availableProductsList.add(p);
    }

    @Override
    public void dropProduct(int id) {
        availableProductsList.remove(id);
    }

    @Override
    public void dropProduct(Product p) {
        availableProductsList.remove(p);
    }
}
