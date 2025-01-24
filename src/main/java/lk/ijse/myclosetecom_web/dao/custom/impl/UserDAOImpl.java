package lk.ijse.myclosetecom_web.dao.custom.impl;

import lk.ijse.myclosetecom_web.dao.SQLUtil;
import lk.ijse.myclosetecom_web.dao.custom.UserDAO;
import lk.ijse.myclosetecom_web.entity.User;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll() throws Exception {
        ArrayList<User> allUsers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM users");

        while (rst.next()) {
            User user = new User(rst.getInt("user_id"), rst.getString("fullName"), rst.getString("username"), rst.getString("email"), rst.getString("password"), rst.getString("u_role"));
            allUsers.add(user);
        }
        return allUsers;
    }

    @Override
    public boolean add(User entity) throws Exception {
        return SQLUtil.execute("INSERT INTO users (user_id, fullName, username, email, password, u_role) VALUES (?,?,?,?,?,?)", entity.getUId(), entity.getFullName(), entity.getUName(), entity.getEmail(), entity.getPassword(), entity.getRole());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return SQLUtil.execute("DELETE FROM users WHERE user_id=?", id);
    }

    @Override
    public boolean update(User entity) throws Exception {
        return SQLUtil.execute("UPDATE users SET fullName=?, username=?, email=?, password=?, u_role=? WHERE user_id=?", entity.getFullName(), entity.getUName(), entity.getEmail(), entity.getPassword(), entity.getRole(), entity.getUId());
    }

    @Override
    public User searchById(Object id) throws Exception {
        return null;
    }

    @Override
    public User getUserByUsername(String username) throws Exception {
        ResultSet rst = SQLUtil.execute("SELECT username, password, u_role FROM users WHERE username=?", username);

        if (rst.next()) {
            return new User(rst.getString("username"), rst.getString("password"), rst.getString("u_role"));
        }
        return null;
    }

    @Override
    public boolean isUsernameOrEmailTaken(String username, String email) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT COUNT(*) FROM users WHERE username = ? OR email = ?");
    }

}
