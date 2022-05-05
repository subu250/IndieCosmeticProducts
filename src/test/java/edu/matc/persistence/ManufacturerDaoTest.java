package edu.matc.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.matc.entity.Manufacturer;
import edu.matc.testUtils.Database;

public class ManufacturerDaoTest {

    private GenericDao<Manufacturer> mfgDao;
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    @BeforeEach
    void setUp() {
        mfgDao = new GenericDao<Manufacturer>(Manufacturer.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

   // @Test
    @DisplayName("Should return a manufacturer.")
    void retrieveMfgById() {
        Manufacturer retrieveMfg = (Manufacturer) mfgDao.getById(1);
        assertNotNull(retrieveMfg);
        assertEquals("Revlon", retrieveMfg.getManufacturerName());
    }
}