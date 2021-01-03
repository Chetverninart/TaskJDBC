package TaskJDBC.dao;

import TaskJDBC.model.User;
import TaskJDBC.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private final Statement STATEMENT;

    private static final String INSERT_NEW = "INSERT INTO testjdbc.users(name, lastName, age) VALUES(?,?,?)";

    public UserDaoJDBCImpl() {
        Util.createConnection();
        this.STATEMENT = Util.getStatement();
    }

    public void createUsersTable() {
        try {
            STATEMENT.execute("CREATE TABLE `testjdbc`.`users` (\n" +
                    "  `id` INT(19) NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `lastName` VARCHAR(45) NOT NULL,\n" +
                    "  `age` INT(3) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            System.out.println("Table created");
        } catch (SQLException e) {
            System.err.println("Table don't created");
        }
    }

    public void dropUsersTable() {

        try {
            STATEMENT.execute("DROP TABLE `testjdbc`.`users`;");
            System.out.println("Table dropped");
        } catch (SQLException e) {
            System.err.println("Table don't dropped");
        }

    }

    public void saveUser(String name, String lastName, byte age) {

        try {
            PreparedStatement preparedStatement = Util.getConnection().prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.execute();

            System.out.printf("User с именем – %s добавлен в базу данны\n", name);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("User don't saved");
        }

    }

    public void removeUserById(long id) {

        String query = "DELETE FROM users WHERE id =" + id;
        try {
            STATEMENT.execute(query);
            System.out.println("User deleted");
        } catch (SQLException e) {
            System.err.println("User don't deleted");
        }

    }

    public List<User> getAllUsers() {

        String query = "SELECT * FROM users;";
        List<User> users = new ArrayList<>();

        try {
            ResultSet resultSet = STATEMENT.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                users.add(user);
            }
            System.out.println("Users list created");
        } catch (SQLException e) {
            System.err.println("Users list don't created");
        }

        return users;
    }

    public void cleanUsersTable() {

        try {
            STATEMENT.execute("TRUNCATE TABLE users;");
            System.out.println("Table cleared");
        } catch (SQLException e) {
            System.err.println("Table don't cleared");
        }

    }

}
