package edu.matc.persistence;

import edu.matc.entity.Order;
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
 * The type Order dao test.
 */

class OrderDaoTest {

    /**
     * The User dao.
     */
    GenericDao userDao;
    /**
     * The Order dao.
     */
    GenericDao orderDao;

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
        orderDao = new GenericDao(Order.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }


    /**
     * Verifies gets all orders successfully.
     */
    @Test
    void getAllOrdersSuccess() {
        List<Order> orders = orderDao.getAll();
        assertEquals(7, orders.size());
    }


    /**
     * Verifies a order is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Order retrievedOrder = (Order) orderDao.getById(2);
        assertNotNull(retrievedOrder);
        assertEquals("Cetaphil", retrievedOrder.getDescription());
    }

    /**
     * Verify successful insert of a order
     */
    @Test
    void insertSuccess() {

        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        Order newOrder = new Order("Cerave", user);
        user.addOrder(newOrder);

        int id = orderDao.insert(newOrder);

        assertNotEquals(0, id);
        Order insertedOrder = (Order) orderDao.getById(id);
        assertEquals("Cerave", insertedOrder.getDescription());
        assertNotNull(insertedOrder.getUser());
        assertEquals("Sam", insertedOrder.getUser().getFirstName());
    }


    /**
     * Verify successful delete of order
     */
    @Test
    void deleteSuccess() {

        Order delete = (Order) orderDao.getById(3);
        assertNull(orderDao.getById(3));
    }

    /**
     * Verify successful update of order
     */
    @Test
    void updateSuccess() {
        String description = "Aveeno";

        Order orderToUpdate = (Order) orderDao.getById(4);
        orderToUpdate.setDescription(description);
        orderDao.saveOrUpdate(orderToUpdate);
        Order retrievedOrder = (Order) orderDao.getById(4);
        assertEquals(description, retrievedOrder.getDescription());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Order> orders = orderDao.getByPropertyEqual("description", "Cerave");
        assertEquals(2, orders.size());
        assertEquals(1, orders.get(0).getId());
    }

}