package edu.matc.persistence;

import edu.matc.persistence.external.ProductApiDao;
import org.junit.jupiter.api.Test;


public class ProductApiDaoTest {

        @Test
        void getProductApiResponseSuccess()  throws Exception {
            ProductApiDao dao = new ProductApiDao();
          //  ProductApiItem[] brand = dao.find("maybelline", "10.29");
            String proType = "Maybelline Face Studio Master Hi-Light Light Booster Bronzer";

         //   String retrievedBrand  = brand[0].getName();

            //assertEquals(proType, retrievedBrand);
        }
}



