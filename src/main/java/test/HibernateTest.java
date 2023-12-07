package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.internetStore.models.entities.productEntities.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HibernateTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void setUp() {
        // Создание конфигурации Hibernate 
        Configuration configuration = new Configuration().configure();

        // Создание фабрики сессий 
        sessionFactory = configuration.buildSessionFactory();

        // Получение сессии 
        session = sessionFactory.openSession();

        // Начало транзакции 
        transaction = session.beginTransaction();
    }

    @After
    public void tearDown() {
        // Откат транзакции 
        transaction.rollback();

        // Закрытие сессии 
        session.close();

        // Закрытие фабрики сессий 
        sessionFactory.close();
    }

    @Test
    public void testHibernate() {
        // Тестирование Hibernate здесь
        // Пример: Создание и сохранение сущности в базе данных 
        Product product = new Product();
        product.setProductname("IPHONEEEEEEEEEE");
        product.setPrice(30000000);
        product.setCategory("SVIN_S_POMADOI");
        product.setWarehouseAddress("Str.POMADNAYA");
        session.persist(product);
        // Проверка, что сущность сохранена успешно
        assertEquals(11, product.getProductid());
    }
    @Test
    public void testDrop(){
        Long id = 1L;
        Product product = session.get(Product.class, id);
        session.delete(product);
        assertEquals(1, product.getProductid());
    }


}