package org.internetStore.dal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.internetStore.models.entities.productEntities.Product;

import java.util.List;

public class DataAccessLayer {

    public List<Product> getProductsFromDatabase(){
        //Савелий Палыч, достаньте все продукты из таблички "Продукт" и поместите их в этот список
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root);

        List<Product> products = session.createQuery(query).getResultList();

//        for (Product product : products) {
//            System.out.println(product.getProductName());
//            System.out.println(product.getCategory());
//        }

        return products;
    }
    public Product getProductFromDatabaseByID(int id){
        //Савелий Палыч, достаньте продукт из таблички "Продукт" по id и поместите его в этот продукт
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products/0
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        Long productId = 1L;

        Product product = session.get(Product.class, productId);
//        System.out.println(product.getProductName());
//        System.out.println(product.getCategory());

        Product1 product1 = new Product1();
        product1.setProductName(product.getProductName());
        product1.setCategory(product.getCategory());
        session.persist(product1);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();

        return product1;
    }
    public void newProductToDatabase(){
        //Я пока не придумал ничего, пока тут нет моих пакостей можешь создать продукт вручную и кинуть в БД
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products/new
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

//        @Entity
//        @Table(name = "my_table")
//        @Getter
//        @Setter
//        @AllArgsConstructor
//        public class MyEntity {
//            @Id
//            @GeneratedValue(strategy = GenerationType.IDENTITY)
//            private Long id;
//
//            @Column(name = "name")
//            private String name;
//
//        }
//        <property name="hibernate.hbm2ddl.auto">create</property>
////      в hibernate.cfg.xml
//
//        public static void main(String[] args) {
//            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//            Session session = sessionFactory.openSession();
//            Transaction transaction = null;
//
//            try {
//                transaction = session.beginTransaction();
//
//                MyEntity entity = new MyEntity();
//                entity.setName("Example");
//
//                session.save(entity);
//
//                transaction.commit();
//            } catch (Exception e) {
//                if (transaction != null) {
//                    transaction.rollback();
//                }
//                e.printStackTrace();
//            } finally {
//                session.close();
//            }
//        }
        // это гадость чтоб без SQL создать таблицу
        Product product = new Product();
        product.setProductName("qwe");
        product.setCategory("svin");

        session.persist(product);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }
    public void updateProductFromDatabaseByID(int id){
        //Измени пакость на новую пакость, тоже пока вручную
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products/update/0
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        Long productId = 1L;
        Product product = session.get(Product.class, productId);
        System.out.println(product.getProductName());
        product.setProductName("name");

        session.update(product);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }
    public void dropProductFromDatabaseByID(int id){
        //УДАЛИ ПАКОСТЬ, УДАЛИ ПАКОСТЬ, УДАЛИИИИИИИИИИИИИИИИ ПААААААААААКООООООООООООООООООСТЬ
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products/drop/0
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        long productId = 1L;
        Product product = session.get(Product.class, productId);
        session.delete(product);

        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }

}
