package lk.ijse.myclosetecom_web.dao.custom;

import lk.ijse.myclosetecom_web.dao.CrudDAO;
import lk.ijse.myclosetecom_web.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends CrudDAO<User> {
    User getUserByUsername(String username) throws Exception;

    boolean isUsernameOrEmailTaken(String username, String email) throws SQLException, ClassNotFoundException;
}
