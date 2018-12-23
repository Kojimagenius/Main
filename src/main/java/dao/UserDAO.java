package dao;

import model.User;

public interface UserDAO extends JpaRepository<User, Long> {
}
