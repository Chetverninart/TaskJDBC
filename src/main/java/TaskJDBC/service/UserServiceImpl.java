package TaskJDBC.service;

import TaskJDBC.dao.UserDao;
import TaskJDBC.dao.UserDaoJDBCImpl;
import TaskJDBC.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao a;

    public UserServiceImpl() {
        a = new UserDaoJDBCImpl();
    }

    public void createUsersTable() {
        a.createUsersTable();
    }

    public void dropUsersTable() {
        a.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        a.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        a.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return a.getAllUsers();
    }

    public void cleanUsersTable() {
        a.cleanUsersTable();
    }

}
