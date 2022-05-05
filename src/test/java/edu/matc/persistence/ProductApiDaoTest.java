package edu.matc.persistence;

import org.junit.jupiter.api.Test;
import product.api.ProductApiItem;
import static org.junit.jupiter.api.Assertions.*;


public class ProductApiDaoTest {

        @Test
        void getProductApiResponseSuccess()  throws Exception {
            ProductApiDao dao = new ProductApiDao();
            ProductApiItem[] brand = dao.getProductResponse("maybelline", "10.29");
            String proType = "Maybelline Face Studio Master Hi-Light Light Booster Bronzer";

            String retrievedBrand  = brand[0].getName();

            assertEquals(proType, retrievedBrand);
        }
}



