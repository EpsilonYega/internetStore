package org.internetStore.service;

import org.internetStore.dal.DataAccessLayer;
import org.internetStore.models.entities.productEntities.Product;
import org.internetStore.models.entities.warehouseEntities.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    DataAccessLayer dataAccessLayer = new DataAccessLayer();
    public List<Warehouse> getWarehouseList(){
        return dataAccessLayer.getWarehousesFromDatabase();
    }
    public Warehouse getWarehouseByID(int id) {
        return dataAccessLayer.getWarehouseFromDatabaseByID(id);
    }
    public void newWarehouse(Warehouse warehouse){
        dataAccessLayer.newWarehouseToDatabase(warehouse);
    }
    public void updateWarehouse(int id, Warehouse warehouse) {
        dataAccessLayer.updateWarehouseFromDatabaseByID(id, warehouse);
    }
    public void dropWarehouse(int id) {
        dataAccessLayer.dropWarehouseFromDatabaseByID(id);
    }
}