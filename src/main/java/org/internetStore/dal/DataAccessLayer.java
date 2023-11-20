package org.internetStore.dal;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.internetStore.models.entities.HibernateUtil;
import org.internetStore.models.entities.productEntities.Product;

import java.util.List;



public class DataAccessLayer {
    private Session session;

    public Session getSession() {
        return session;
    }

    public DataAccessLayer() {
        session = HibernateUtil.getSessionFactory().openSession();


    }

    public void newProductToDatabase(){
        //Я пока не придумал ничего, пока тут нет моих пакостей можешь создать продукт вручную и кинуть в БД
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products/new
        session.getTransaction().begin();
        Product product = new Product();
        product.setProductname("qweaedgsdfgjfmh,vg");
        product.setCategory("svin");
        product.setCharacteristicsList("qwe");

        session.persist(product);
        session.getTransaction().commit();

    }
    public List<Product> getProductsFromDatabase(){
        //Савелий Палыч, достаньте все продукты из таблички "Продукт" и поместите их в этот список
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products


        session.getTransaction().begin();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root);

        List<Product> products = session.createQuery(query).getResultList();
        session.persist(products);
//        for (Product product : products) {
//            System.out.println(product.getCategory());
//            System.out.println(product.getProductname());
//            System.out.println(product.getCharacteristicsList());
//
//        }

        session.getTransaction().commit();
        return products;
    }
    public void copyToAnotherTable(){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        session.getTransaction().begin();
//
//        Long productId = 1L;
//
//        Product product = session.get(Product.class, productId);
//
//        Product1 product1 = new Product1();
//        product1.setProductName(product.getProductName());
//        product1.setCategory(product.getCategory());
//        session.persist(product1);
//        session.getTransaction().commit();
//        session.close();
//        HibernateUtil.close();
    }
    public Product getProductFromDatabaseByID(int id){
//       http://localhost:8080/main/products/1

        session.getTransaction().begin();


        Product product = session.get(Product.class, id);

        session.persist(product);
        session.getTransaction().commit();
        return product;
    }

    public void updateProductFromDatabaseByID(int id){
        http://localhost:8080/main/products/update/1

        session.getTransaction().begin();

        Product product = session.get(Product.class, id);
        product.setProductname("name");

        session.update(product);
        session.getTransaction().commit();

    }
    public void dropProductFromDatabaseByID(int id){
         http://localhost:8080/main/products/drop/1

        session.getTransaction().begin();

        Product product = session.get(Product.class, id);
        session.delete(product);

        session.getTransaction().commit();


    }


}
