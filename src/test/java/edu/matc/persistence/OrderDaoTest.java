package edu.matc.persistence;

import edu.matc.entity.Order;
import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Order dao test.
 */
class OrderDaoTest {

    OrderDao dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new OrderDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verifies gets all orders successfully.
     */
    @Test
    void getAllOrdersSuccess() {
        List<Order> orders = dao.getAllOrders();
        assertEquals(7, orders.size());
    }


    /**
     * Verifies a order is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Order retrievedOrder = dao.getById(2);
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

        int id = dao.insert(newOrder);

        assertNotEquals(0,id);
        Order insertedOrder = dao.getById(id);
        assertEquals("Cerave", insertedOrder.getDescription());
        assertNotNull(insertedOrder.getUser());
        assertEquals("Sam", insertedOrder.getUser().getFirstName());
    }


    /**
     * Verify successful delete of order
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful update of order
     */
    @Test
    void updateSuccess() {
        String description = "Aveeno";
        Order orderToUpdate = dao.getById(4);
        orderToUpdate.setDescription(description);
        dao.saveOrUpdate(orderToUpdate);
        Order retrievedOrder = dao.getById(4);
        assertEquals(description, retrievedOrder.getDescription());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Order> orders = dao.getByPropertyEqual("description", "Cerave");
        assertEquals(2, orders.size());
        assertEquals(1, orders.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Order> orders = dao.getByPropertyLike("description", "Hand Cream");
        assertEquals(1, orders.size());
    }
}