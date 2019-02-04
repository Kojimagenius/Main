package Services;

import model.User;

import java.util.List;

public interface UserService {
    void addUser(User usr);
    void deleteBank(long id);
    User getById(long id);
    User editUser(User usr);
    List<User>getAllUsers();

}
