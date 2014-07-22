import control.dao.ImageDAO;
import control.dao.UserDAO;
import model.User;

public class UserTest {
    public static void main(String[] args) {
        editUser();


    }

    public static void createUsers(int qty) {
        for (int i = 1; i <= qty; i++) {
            User user = new User("first name" + i,
                    "last name" + i, System.currentTimeMillis(), "username" + i, i + "@test", "1234", ImageDAO.getInstance().getImage(1));
            UserDAO.getInstance().addUser(user);
        }
    }

    public static void editUser(){
        User user = UserDAO.getInstance().getUser(1);
        User user2 = UserDAO.getInstance().getUser(2);

        user.setPassword("1234");
        user2.setPassword("1234");
        user.setProfilePicture(ImageDAO.getInstance().getImage(1));
        user2.setProfilePicture(ImageDAO.getInstance().getImage(1));
        user.setFirstName("Nicolas");
        user2.setFirstName("Franco");
        user.setLastName("Schejtman");
        user2.setLastName("Testori");
        user.setUserName("nschejtman");
        user2.setUserName("ftestori");

        UserDAO.getInstance().addUser(user);
        UserDAO.getInstance().addUser(user2);
    }
}
