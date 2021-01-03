package TaskJDBC.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/testjdbc?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection CONNECTION;
    private static Statement STATEMENT;

    public static void createConnection() {
        try {
            CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
            STATEMENT = CONNECTION.createStatement();
            System.out.println("Connection create");
        } catch (SQLException e) {
            System.err.println("Connection don't create");
        }
    }

    public static Statement getStatement() {
        return STATEMENT;
    }

    public static Connection getConnection() {
        return CONNECTION;
    }

}


