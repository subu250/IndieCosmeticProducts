package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class UserDaoTest {

    UserDao dao;


    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    /**
     * Verify successful retrieval of a User
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(5);
        assertNotNull(retrievedUser);
        assertEquals("Mack", retrievedUser.getLastName());
    }


    /**
     * Verify successful insert of User
     */

    @Test
    void insertSuccess() {

        User newUser = new User("Sara", "stone", "intstone", "Userone@gmail.com0", "user789");
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertEquals("Sara", insertedUser.getFirstName());
    }

    /**
     * Verify successful delete of User
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }


    /**
     * Verify successful update of a User
     */
    @Test
    void updateSuccess() {
        String firstname = "James";
        User userToUpdate = dao.getById(6);
        userToUpdate.setFirstName(firstname);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser= dao.getById(6);
        assertEquals(firstname, retrievedUser.getFirstName());
    }

    /**
     * Verify successful retrieval of all Users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(5, users.size());
    }

}