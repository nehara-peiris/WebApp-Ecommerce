package lk.ijse.myclosetecom_web.bo.custom.impl;

import lk.ijse.myclosetecom_web.bo.custom.UserBO;
import lk.ijse.myclosetecom_web.dao.DAOFactory;
import lk.ijse.myclosetecom_web.dao.custom.UserDAO;
import lk.ijse.myclosetecom_web.dto.UserDTO;
import lk.ijse.myclosetecom_web.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public List<UserDTO> getAllUsers() throws Exception {
        List<User> userList = userDAO.getAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(new UserDTO(user.getUId(), user.getFullName(), user.getUName(), user.getEmail(), user.getPassword(), user.getRole()));
        }
        return userDTOList;
    }

    @Override
    public boolean addUser(UserDTO dto) throws Exception {
        User user = new User(dto.getUId(), dto.getFullName(), dto.getUName(), dto.getEmail(), dto.getPassword(), dto.getRole());
        return userDAO.add(user);
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
        return userDAO.delete(id);
    }

    @Override
    public boolean updateUser(UserDTO dto) throws Exception {
        User user = new User(dto.getUId(), dto.getFullName(), dto.getUName(), dto.getEmail(), dto.getPassword(), dto.getRole());
        return userDAO.update(user);
    }

    @Override
    public UserDTO searchUserById(Object id) throws Exception {
        return null;
    }

    @Override
    public UserDTO getUsernameAndPassword(String username) throws Exception {
        User user = userDAO.getUserByUsername(username);
        if (user != null) {
            return new UserDTO(user.getUName(), user.getPassword(), user.getRole());
        }
        return null;
    }

    @Override
    public boolean isUsernameOrEmailTaken(String username, String email) throws SQLException, ClassNotFoundException {
        return userDAO.isUsernameOrEmailTaken(username, email);
    }

}
