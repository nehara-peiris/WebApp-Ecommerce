package lk.ijse.myclosetecom_web.dao;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO{
    List<T> getAll() throws Exception;

    boolean add(T entity) throws Exception;

    boolean delete(String id) throws Exception;

    boolean update(T entity) throws Exception;

    T searchById(Object id) throws Exception;
}
