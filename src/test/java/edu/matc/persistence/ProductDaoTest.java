package edu.matc.persistence;

import edu.matc.entity.Order;
import edu.matc.entity.Product;
import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Product dao test.
 */


class ProductDaoTest {

    /**
     * The User dao.
     */
    GenericDao userDao;
    /**
     * The Order dao.
     */
    GenericDao productDao;

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        userDao = new GenericDao(User.class);
        productDao = new GenericDao(Product.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all products successfully.
     */
  //  @Test
    void getAllProductsSuccess() {
        List<Order> products = productDao.getAll();
        assertEquals(7, products.size());
    }

    /**
     * Verifies a product is returned correctly based on id search
     */
  //  @Test
    void getByIdSuccess() {
        Product retrievedProduct = (Product) productDao.getById(2);
        assertNotNull(retrievedProduct);
        assertEquals("Users", retrievedProduct.getBrand());
    }

    /**
     * Verify successful insert of a product
     */
  //  @Test
    void insertSuccess() {

        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        Product newProduct = new Product("Cerave", user);
       // user.addOrder(newOrder);
        int id = productDao.insert(newProduct);
        assertNotEquals(0, id);

        Product insertedProduct = (Product) productDao.getById(id);
        assertEquals("ABC", insertedProduct.getBrand());
        assertNotNull(insertedProduct.getUser());
        assertEquals("Rose", insertedProduct.getUser().getFirstName());
    }


    /**
     * Verify successful delete of product
     */
  //  @Test
    void deleteSuccess() {
        Product delete = (Product) productDao.getById(3);

        assertNull(productDao.getById(3));
    }

    /**
     * Verify successful update of product
     */
  //  @Test
    void updateSuccess() {
        String brand = "Cerave";

        Product productToUpdate = (Product) productDao.getById(3);
        productToUpdate.setBrand(brand);
        productDao.saveOrUpdate(productToUpdate);
        Product retrievedProduct = (Product) productDao.getById(3);
        assertEquals(brand, retrievedProduct.getBrand());
    }

    /**
     * Verify successful get by property (equal match)
     */
 //   @Test
    void getByPropertyEqualSuccess() {

        List<Product> products = productDao.getByPropertyEqual("brand", "b");
        assertEquals(1, products.size());
        assertEquals(2, products.get(0).getId());
    }


}
