import dao.UserDAO;
        import model.User;

public class testMain {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("Juancho");
        user.setPassword("Talarga");

        UserDAO.addUser(user);

    }
}
