package org.internetStore.dal;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import org.hibernate.Session;
import org.internetStore.models.entities.HibernateUtil;
import org.internetStore.models.entities.productEntities.Product;

import java.util.ArrayList;
import java.util.List;



@Getter
public class DataAccessLayer {
    private Session session;

    public void newProductToDatabase(Product product){
     http://localhost:8080/main/products/new
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        List<String> characteristicsList = product.getCharacteristicsList();
        product.setProductname(product.getProductname());
        product.setCategory(product.getCategory());
        product.setCharacteristicsList(characteristicsList);

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

//    public void updateProductFromDatabaseByID(int id){
//        http://localhost:8080/main/products/update/2
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.getTransaction().begin();
//        Product product = session.get(Product.class, id);
//        product.setProductname("Galaxy S21");
//
//        session.update(product);
//        session.getTransaction().commit();
//        session.close();
//    }
public void updateProductFromDatabaseByID(int id, Product newProduct){
    //http://localhost:8080/main/products/update/2
//    session = HibernateUtil.getSessionFactory().openSession();
//    session.getTransaction().begin();
//    Product product = session.get(Product.class, id);
//    product.setProductname(newProduct.getProductname());
//    product.setCategory(newProduct.getCategory());
//    product.setCharacteristicsList(newProduct.getCharacteristicsList());
//    session.update(product);
//    session.getTransaction().commit();
//    session.close();
}
    public void dropProductFromDatabaseByID(int id){
         //http://localhost:8080/main/products/drop/1
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.getTransaction().begin();
//        Product product = session.get(Product.class, id);
//        session.delete(product);
//
//        session.getTransaction().commit();
//        session.close();

    }
}
