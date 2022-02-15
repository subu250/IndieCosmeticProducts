package edu.matc.persistence;

import edu.matc.entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * Access products in the product table.
 *
 * @author subu
 *
 */

public class ProductDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all products.
     *
     * @return the all products
     */
    public List<Product> getAllProducts() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        List<Product> products = session.createQuery(query).getResultList();
        session.close();
        return products;
    }


    /**
     * Gets a product by id
     * @param id products id to search by
     * @return a product
     */
    public Product getById(int id) {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    /**
     * update product
     * @param product  Product to be inserted or updated
     */
    public void saveOrUpdate(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(product);
        transaction.commit();
        session.close();
    }

    /**
     * update product
     * @param product  Product to be inserted or updated
     * @return id of the inserted product
     */
    public int insert(Product product) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(product);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a product
     * @param product Product to be deleted
     */
    public void delete(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
    }


    /**
     * Get product by property (exact match)
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of orders meeting the criteria search
     */
    public List<Product> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for product with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery( Product.class );
        Root<Product> root = query.from( Product.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Product> products = session.createQuery( query ).getResultList();

        session.close();
        return products;
    }

    /**
     * Get product by property (like)
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of orders meeting the criteria search
     */
    public List<Product> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for order with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery( Product.class );
        Root<Product> root = query.from( Product.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Product> products = session.createQuery( query ).getResultList();
        session.close();
        return products;
    }


}