package Services;

import model.User;

import java.util.List;

public interface UserService {
    User addUser(User usr);
    void delete(long id);
    User getById(long id);
    User editUser(User usr);
    List<User>getAllUsers();

}
