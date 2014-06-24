import control.dao.CountryDAO;
import control.dao.ImageDAO;
import control.dao.TypeDAO;
import control.dao.UserDAO;
import model.Country;
import model.Image;
import model.Type;
import model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Run after re-initializing the db.
 * Run only once!
 */
public class Initializer {
    public static void main(String[] args) {
        //Update the schema
        UpdateDBSchema.main(null);

        //Add default image
        Image image = new Image("secured/media/img/defaultuserpic.png");
        ImageDAO.addImage(image);

        //Create users for franco & nico
        User nico = new User("Nicol+" +
                "as", "Schejtman", System.currentTimeMillis(), "nschejtman", "nschejtman@hotmail.com",
                "1234", ImageDAO.getImage(1));
        User franco = new User("Franco", "Testori", System.currentTimeMillis(), "ftestori", "franco.testori@hotmail.com",
                "1234", ImageDAO.getImage(1));
        UserDAO.addUser(nico);
        UserDAO.addUser(franco);

        //Adds countries
        Country testCountry = new Country("Test Country");
        CountryDAO.addCountry(testCountry);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Initializer.class.getClassLoader().getResource("initial_data/countries.txt").getPath().replaceAll("%20", " ")));
            String countryName = null;
            countryName = br.readLine();
            while (countryName != null) {
                Country country = new Country(countryName);
                CountryDAO.addCountry(country);
                countryName = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Adds types
        Type testType = new Type("Test type");
        TypeDAO.addType(testType);
        try {
            br = new BufferedReader(new FileReader(Initializer.class.getClassLoader().getResource("initial_data/types.txt").getPath().replaceAll("%20", " ")));
            String typeName = null;
            typeName = br.readLine();
            while (typeName != null) {
                Type type = new Type(typeName);
                TypeDAO.addType(type);
                typeName = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Creates a project
        ProjectTest.createTestProject();
    }
}
