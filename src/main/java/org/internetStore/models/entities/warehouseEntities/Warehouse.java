package org.internetStore.models.entities.warehouseEntities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.internetStore.models.entities.productEntities.Product;

import javax.annotation.Nullable;
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
    @ManyToMany(mappedBy = "warehouseList")
    private List<Product> availableProductsList;
    public Warehouse(){}

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
