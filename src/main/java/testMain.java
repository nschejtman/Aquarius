
import control.dao.UserDAO;
        import model.User;


public class testMain {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setUserName("franco.testori@hotmail.com");
        user1.setPassword("test1");
        User user2 = new User();
        user2.setUserName("nschejtman@hotmail.com");
        user2.setPassword("test2");


        UserDAO.addUser(user1);
        UserDAO.addUser(user2);

    }
}
