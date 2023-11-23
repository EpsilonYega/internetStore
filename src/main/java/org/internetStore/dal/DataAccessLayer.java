package org.internetStore.dal;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import org.hibernate.Session;
import org.internetStore.models.entities.HibernateUtil;
import org.internetStore.models.entities.productEntities.Product;
import org.internetStore.models.entities.warehouseEntities.Warehouse;

import java.util.ArrayList;
import java.util.List;



@Getter
public class DataAccessLayer {
    private Session session;

    public void newProductToDatabase(Product product){
     http://localhost:8080/main/products/new
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        List<Warehouse> warehouseList = new ArrayList<>();
        for (int i : product.getWarehouseIdList()) {
            warehouseList.add(session.get(Warehouse.class, i));
        }
        product.setWarehouseList(warehouseList);
        session.persist(product);
        session.getTransaction().commit();
        session.close();
    }
    public List<Product> getProductsFromDatabase(){
        http://localhost:8080/main/products
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root);
        List<Product> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public Product getProductFromDatabaseByID(int id){
//       http://localhost:8080/main/products/2
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Product product = session.get(Product.class, id);
        return product;

    }

public void updateProductFromDatabaseByID(int id, Product newProduct){
    //http://localhost:8080/main/products/update/2
    session = HibernateUtil.getSessionFactory().openSession();
    session.getTransaction().begin();
    Product product = session.get(Product.class, id);
    product.setProductname(newProduct.getProductname());
    product.setCategory(newProduct.getCategory());
    product.setCharacteristicsList(newProduct.getCharacteristicsList());
    session.update(product);
    session.getTransaction().commit();
    session.close();
}
    public void dropProductFromDatabaseByID(int id){
         //http://localhost:8080/main/products/drop/1
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
        session.close();

    }

    public void newWarehouseToDatabase(Warehouse warehouse){
        http://localhost:8080/main/products/new
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(warehouse);
        session.getTransaction().commit();
        session.close();
    }
    public List<Warehouse> getWarehousesFromDatabase(){
        http://localhost:8080/main/products
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Warehouse> query = builder.createQuery(Warehouse.class);
        Root<Warehouse> root = query.from(Warehouse.class);
        query.select(root);
        List<Warehouse> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public Warehouse getWarehouseFromDatabaseByID(int id){
//       http://localhost:8080/main/products/2
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Warehouse warehouse = session.get(Warehouse.class, id);
        return warehouse;
    }

    public void updateWarehouseFromDatabaseByID(int id, Warehouse newWarehouse){
        //http://localhost:8080/main/products/update/2
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Warehouse warehouse = session.get(Warehouse.class, id);
        warehouse.setWarehouseAddress(newWarehouse.getWarehouseAddress());
        warehouse.setAvailableProductsList(warehouse.getAvailableProductsList());
        session.update(warehouse);
        session.getTransaction().commit();
        session.close();
    }
    public void dropWarehouseFromDatabaseByID(int id){
        //http://localhost:8080/main/products/drop/1
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Warehouse warehouse = session.get(Warehouse.class, id);
        session.delete(warehouse);
        session.getTransaction().commit();
        session.close();
    }
}
