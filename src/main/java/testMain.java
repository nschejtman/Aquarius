import control.dao.UserDAO;
import model.User;

public class testMain {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("Franco");
        user.setPassword("toystory");
        UserDAO.addUser(user);
        User franco = UserDAO.getUser("Franco");
        System.out.println(franco.getUserName());
    }


}
