package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDaoTest {

    /**
     * The User dao.
     */
    GenericDao userDao;
    /**
     * The Product dao.
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
       // productDao = new GenericDao(ProductDao.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a User
     */
 //   @Test
    void getByIdSuccess() {
        User retrievedUser = (User) userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Mack", retrievedUser.getLastName());
        //assertTrue(expectedUser.equals(actualUser));
    }

    /**
     * Verify successful insert of User
     */

  //  @Test
    void insertSuccess() {

        User newUser = new User("Sara", "stone", "intstone", "Userone@gmail.com0", "user789");
        int id = userDao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User)userDao.getById(id);
        assertEquals("Sara", insertedUser.getFirstName());
    }

    /**
     * Verify successful delete of User
     */
  //  @Test
    void deleteSuccess() {
        User delete = (User) userDao.getById(2);
        assertNull(userDao.getById(2));
    }


    /**
     * Verify successful update of a User
     */
  //  @Test
    void updateSuccess() {
        String firstname = "James";
        User userToUpdate = (User) userDao.getById(6);
        userToUpdate.setFirstName(firstname);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser=(User) userDao.getById(6);
        assertEquals(firstname, retrievedUser.getFirstName());
    }

    /**
     * Verify successful retrieval of all Users
     */
 //   @Test
    void getAllSuccess() {

        List<User> users = userDao.getAll();
        assertEquals(6, users.size());
    }

}