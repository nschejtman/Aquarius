import control.dao.ImageDAO;
import control.dao.UserDAO;
import model.User;

public class UserTest {
    public static void main(String[] args) {
        createUsers(10);


    }

    public static void createUsers(int qty) {
        for (int i = 1; i <= qty; i++) {
            User user = new User("first name" + i,
                    "last name" + i, System.currentTimeMillis(), "username" + i, i + "@test", "1234", ImageDAO.getInstance().getImage(1));
            UserDAO.getInstance().addUser(user);
        }

    }
}
