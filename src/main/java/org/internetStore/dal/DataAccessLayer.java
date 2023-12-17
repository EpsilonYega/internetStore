package org.internetStore.dal;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.internetStore.Main;
import org.internetStore.models.entities.Basket;
import org.internetStore.models.entities.HibernateUtil;
import org.internetStore.models.entities.User;
import org.internetStore.models.entities.productEntities.Product;
import org.internetStore.models.entities.warehouseEntities.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Getter
public class DataAccessLayer {
    private Session session;
    public String newUserToDatabase(User user){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        String name = user.getUsername();
        Query query = session
                .createQuery("FROM User where username = :username")
                .setParameter("username", name);
        User userFrom = (User) query.uniqueResult();
        if (userFrom != null) {
            return "Выберите другое имя";
        }
        String useremail = user.getEmail();
        query = session
                .createQuery("FROM User where email = :email")
                .setParameter("email", useremail);
        userFrom = (User) query.uniqueResult();
        if (userFrom != null) {
            return "Выберите другую почту";
        }
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return "Победа)";
    }
    public User getUserFromDatabaseByUsername(String name){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session
                .createQuery("FROM User where username = :username")
                .setParameter("username", name);
        User userFrom = (User) query.uniqueResult();
        if (userFrom == null) {
            return null;
        }
        return userFrom;
    }
    public List<Basket> getBasketFromDatabase() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        long userId = Main.currentUser.getUserid();
        User localUser = session.get(User.class, userId);
        List<Basket> result = session
                .createQuery("from Basket where user = :user")
                .setParameter("user", localUser)
                .list();
        return result;
    }
    public String newBasketToDatabase(Product product) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Basket> query = builder.createQuery(Basket.class);
        Root<Basket> root = query.from(Basket.class);
        query.select(root);
        List<Basket> basketList = session.createQuery(query).getResultList();

        for (Basket basket : basketList) {
            if (Objects.equals(basket.getProduct().getProductid(), product.getProductid())) {
                return "К сожалению, данный товар уже зарезервирован";
            }
        }

        session.persist(product.addProductToBasket());
        session.getTransaction().commit();
        session.close();
        return "Товар успешно добавлен";
    }
    public void dropProductFromBasketByID(long basketId) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        long userId = Main.currentUser.getUserid();
        Basket basket = session.get(Basket.class, basketId);
        if (basket.getUser().getUserid() == userId) {
            session.delete(basket);
        } else {
            System.out.println(" ");
        }
        session.getTransaction().commit();
        session.close();
    }

    public void newProductToDatabase(Product product){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Warehouse localWarehouse = session.get(Warehouse.class, product.getWarehouseId());
        product.setWarehouseAddress(localWarehouse.getWarehouseAddress());
        session.persist(product);
        session.getTransaction().commit();
        session.close();
    }
    public List<Product> getProductsFromDatabase(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root);
        List<Product> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public Product getProductFromDatabaseByID(long id){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Product product = session.get(Product.class, id);
        return product;
    }
    public List<Product> searchProducts(String searchQuery) {
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        Predicate namePredicate = builder.like(builder.lower(root.get("productname")), "%" + searchQuery.toLowerCase() + "%");
        Predicate categoryPredicate = builder.like(builder.lower(root.get("category")), "%" + searchQuery.toLowerCase() + "%");
        Predicate searchPredicate = builder.or(namePredicate, categoryPredicate);
        query.select(root).where(searchPredicate);
        return session.createQuery(query).getResultList();
    }

public void updateProductFromDatabaseByID(long id, Product newProduct){
    session = HibernateUtil.getSessionFactory().openSession();
    session.getTransaction().begin();
    Product product = session.get(Product.class, id);
    product.setProductname(newProduct.getProductname());
    product.setCategory(newProduct.getCategory());
    product.setCharacteristicsList(newProduct.getCharacteristicsList());
    product.setWarehouseAddress(newProduct.getWarehouseAddress());
    session.update(product);
    session.getTransaction().commit();
    session.close();
}
    public void dropProductFromDatabaseByID(long id){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }

    public void newWarehouseToDatabase(Warehouse warehouse){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(warehouse);
        session.getTransaction().commit();
        session.close();
    }
    public List<Warehouse> getWarehousesFromDatabase(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Warehouse> query = builder.createQuery(Warehouse.class);
        Root<Warehouse> root = query.from(Warehouse.class);
        query.select(root);
        List<Warehouse> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public Warehouse getWarehouseFromDatabaseByID(long id){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Warehouse warehouse = session.get(Warehouse.class, id);
        return warehouse;
    }

    public void updateWarehouseFromDatabaseByID(long id, Warehouse newWarehouse){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Warehouse warehouse = session.get(Warehouse.class, id);
        warehouse.setWarehouseAddress(newWarehouse.getWarehouseAddress());
        session.update(warehouse);
        session.getTransaction().commit();
        session.close();
    }
    public void dropWarehouseFromDatabaseByID(long id){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Warehouse warehouse = session.get(Warehouse.class, id);
        session.delete(warehouse);
        session.getTransaction().commit();
        session.close();
    }
}
