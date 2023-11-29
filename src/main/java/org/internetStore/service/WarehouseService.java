package org.internetStore.service;

import org.internetStore.dal.DataAccessLayer;
import org.internetStore.models.entities.productEntities.Product;
import org.internetStore.models.entities.warehouseEntities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    @Autowired
    DataAccessLayer dataAccessLayer;
    public List<Warehouse> getWarehouseList(){
        return dataAccessLayer.getWarehousesFromDatabase();
    }
    public Warehouse getWarehouseByID(long id) {
        return dataAccessLayer.getWarehouseFromDatabaseByID(id);
    }
    public void newWarehouse(Warehouse warehouse){
        dataAccessLayer.newWarehouseToDatabase(warehouse);
    }
    public void updateWarehouse(long id, Warehouse warehouse) {
        dataAccessLayer.updateWarehouseFromDatabaseByID(id, warehouse);
    }
    public void dropWarehouse(long id) {
        dataAccessLayer.dropWarehouseFromDatabaseByID(id);
    }
}
