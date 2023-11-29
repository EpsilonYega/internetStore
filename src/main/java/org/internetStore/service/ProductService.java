package org.internetStore.service;

import org.internetStore.dal.DataAccessLayer;
import org.internetStore.models.entities.productEntities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    DataAccessLayer dataAccessLayer;
    public List<Product> getProductList(){
        return dataAccessLayer.getProductsFromDatabase();
    }
    public List<Product> getProductListByQuery(String searchQuery){
        return dataAccessLayer.searchProducts(searchQuery);
    }
    public Product getProductByID(long id) {
        return dataAccessLayer.getProductFromDatabaseByID(id);
    }
    public void newProduct(Product product){
        dataAccessLayer.newProductToDatabase(product);
    }
    public void updateProduct(long id, Product product) {
        dataAccessLayer.updateProductFromDatabaseByID(id, product);
    }
    public void dropProduct(long id) {
        dataAccessLayer.dropProductFromDatabaseByID(id);
    }
}
