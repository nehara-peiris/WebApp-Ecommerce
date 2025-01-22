package lk.ijse.myclosetecom_web.dao.custom.impl;

import lk.ijse.myclosetecom_web.config.FactoryConfiguration;
import lk.ijse.myclosetecom_web.dao.custom.CategoryDAO;
import lk.ijse.myclosetecom_web.entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public List<Category> getAll() throws Exception {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            return session.createQuery("FROM Category", Category.class).list();
        } catch (Exception e) {
            throw new Exception("Failed to retrieve all categories", e);
        }
    }

    @Override
    public boolean add(Category entity) throws Exception {
        Transaction transaction = null;
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new Exception("Failed to add category", e);
        }
    }

    @Override
    public boolean delete(Category entity) throws Exception {
        Transaction transaction = null;
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new Exception("Failed to delete category", e);
        }
    }

    @Override
    public boolean update(Category entity) throws Exception {
        Transaction transaction = null;
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new Exception("Failed to update category", e);
        }
    }

    @Override
    public Category searchById(Object id) throws Exception {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            return session.get(Category.class, (Long) id);
        } catch (Exception e) {
            throw new Exception("Failed to search category by ID", e);
        }
    }
}
