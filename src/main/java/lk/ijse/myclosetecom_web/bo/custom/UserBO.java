package lk.ijse.myclosetecom_web.bo.custom;

import lk.ijse.myclosetecom_web.bo.SuperBO;
import lk.ijse.myclosetecom_web.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {
    List<UserDTO> getAllUsers() throws Exception;

    boolean addUser(UserDTO dto) throws Exception;

    boolean deleteUser(String id) throws Exception;

    boolean updateUser(UserDTO dto) throws Exception;

    UserDTO searchUserById(Object id) throws Exception;

    UserDTO getUsernameAndPassword(String username) throws Exception;

    boolean isUsernameOrEmailTaken(String username, String email) throws SQLException, ClassNotFoundException;
}
