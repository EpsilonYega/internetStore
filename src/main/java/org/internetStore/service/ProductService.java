package org.internetStore.service;

import org.internetStore.dal.DataAccessLayer;
import org.internetStore.models.entities.productEntities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
//    @Autowired
//    List<Product> productList;
    DataAccessLayer dataAccessLayer = new DataAccessLayer();
    public List<Product> getProductList(){
        return dataAccessLayer.getProductsFromDatabase();
    }
    public Product getProductByID(int id) {
        return dataAccessLayer.getProductFromDatabaseByID(id);
    }
    public void newProduct(){
        dataAccessLayer.newProductToDatabase();
    }
    public void updateProduct(int id) {
        dataAccessLayer.updateProductFromDatabaseByID(id);
    }
    public void dropProduct(int id) {
        dataAccessLayer.dropProductFromDatabaseByID(id);
    }
}
