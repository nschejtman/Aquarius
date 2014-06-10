import control.dao.TypeDAO;
import model.Type;

public class testMain {
    public static void main(String[] args) {

        Type type = new Type("Admin");
        Type type2 = new Type("Root");
        Type type3 = new Type("Beta");
        TypeDAO.addType(type);
        TypeDAO.addType(type2);
        TypeDAO.addType(type3);


    }
}
