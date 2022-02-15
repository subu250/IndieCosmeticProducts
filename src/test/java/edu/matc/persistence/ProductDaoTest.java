package edu.matc.persistence;

import edu.matc.entity.Product;
import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Product dao test.
 */
class ProductDaoTest {

    ProductDao dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new ProductDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verifies gets all products successfully.
     */
    @Test
    void getAllProductsSuccess() {
        List<Product> orders = dao.getAllProducts();
        assertEquals(7, orders.size());
    }


    /**
     * Verifies a product is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Product retrievedProduct = dao.getById(2);
        assertNotNull(retrievedProduct);
        assertEquals("Users", retrievedProduct.getBrand());
    }

    /**
     * Verify successful insert of a product
     */
    @Test
    void insertSuccess() {

        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        Product newProduct = new Product("Cerave", user);
       // user.addOrder(newOrder);
        int id = dao.insert(newProduct);

        assertNotEquals(0, id);
        Product insertedProduct = dao.getById(id);
        assertEquals("ABC", insertedProduct.getBrand());
        assertNotNull(insertedProduct.getUser());
        assertEquals("Rose", insertedProduct.getUser().getFirstName());
    }


    /**
     * Verify successful delete of product
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful update of product
     */
    @Test
    void updateSuccess() {
        String brand = "Cerave";
        Product productToUpdate = dao.getById(3);
        productToUpdate.setBrand(brand);
        dao.saveOrUpdate(productToUpdate);
        Product retrievedProduct = dao.getById(3);
        assertEquals(brand, retrievedProduct.getBrand());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Product> products = dao.getByPropertyEqual("brand", "b");
        assertEquals(1, products.size());
        assertEquals(2, products.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Product> products = dao.getByPropertyLike("brand", "b");
        assertEquals(3, products.size());
    }
}
