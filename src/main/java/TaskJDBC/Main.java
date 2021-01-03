package TaskJDBC;

import TaskJDBC.model.User;
import TaskJDBC.service.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService a = new UserServiceImpl();

//        Создание таблицы User(ов)
        a.createUsersTable();

//        Добавление 4 User(ов) в таблицу с данными на свой выбор.
//        После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
        a.saveUser("Artem", "C", (byte) 23);
        a.saveUser("Fil", "T", (byte) 23);
        a.saveUser("Dima", "U", (byte) 24);
        a.saveUser("Roma", "A", (byte) 24);

//        Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
        List<User> userList = a.getAllUsers();
        for (User u : userList) {
            System.out.println(u);
        }

//        Очистка таблицы User(ов)
        a.cleanUsersTable();

//        Удаление таблицы
        a.dropUsersTable();

    }

}
