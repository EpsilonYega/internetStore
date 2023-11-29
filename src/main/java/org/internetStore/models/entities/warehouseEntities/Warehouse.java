package org.internetStore.models.entities.warehouseEntities;

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
    private long warehouseId;
    @Column(name = "warehouseAddress")
    private String warehouseAddress;
    public Warehouse(){}
    public Warehouse(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }
}
