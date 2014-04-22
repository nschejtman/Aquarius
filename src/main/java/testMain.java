
import control.dao.UserDAO;
        import model.User;


public class testMain {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("Domingo");
        user.setPassword("Concha");


        UserDAO.addUser(user);

    }
}
