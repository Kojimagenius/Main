package Services.Impl;

import Services.UserService;
import dao.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserDAO userRepository;


    public User addUser(User usr) {
    User newUser = userRepository.saveAndFlush(usr);
    return newUser;
    }

    public void delete(long id) {
    userRepository.delete(getById(id));
    }

    public User getById(long id) {
        return userRepository.getOne(id);
    }

    public User editUser(User usr) {

        return userRepository.saveAndFlush(usr);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
