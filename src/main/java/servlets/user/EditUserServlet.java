package servlets.user;

import control.dao.ImageDAO;
import control.dao.UserDAO;
import model.Image;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by franco on 21/07/2014.
 */
@WebServlet(name="EditUserServlet", urlPatterns = "/secured/edituser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the user id from url
        Long id = Long.parseLong(req.getParameter("id"));
        User user = UserDAO.getInstance().getUser(id);
        //Get BirthDate
        String birthDate = getBirthDate(user);

        if(user.getUserName().equals(req.getUserPrincipal().getName())){
            ServletContext servletContext = getServletContext();
            RequestDispatcher rd = servletContext.getRequestDispatcher("/secured/edituser.jsp");
            req.setAttribute("user", user);
            req.setAttribute("birthday", birthDate);
            rd.forward(req,resp);
        }else {
            resp.sendRedirect("/secured/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserDAO.getInstance().getUser(req.getUserPrincipal().getName());

        String firstName = req.getParameter("userfirstname");
        String lastName = req.getParameter("userlastname");
        String email = req.getParameter("useremail");
        String password = req.getParameter("password");
        Image image = new Image(req.getParameter("image_path"));

        User edited = setUserParameters(user,firstName,lastName,email,password, ImageDAO.getInstance().getImage(1));
        try{
            edited.setBirthday(setBirthDate(req));
        } catch (ParseException e) {e.printStackTrace();}

        UserDAO.getInstance().addUser(edited);
        resp.sendRedirect("/secured/profile?id=" + edited.getId());
    }

    public static User setUserParameters(User user, String firstName, String lastName, String email, String password, Image image){
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setProfilePicture(image);
        user.setPassword(password);
        return user;
    }

    public static long setBirthDate(HttpServletRequest request) throws ParseException {
        String date = request.getParameter("birthday");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date1 = sdf.parse(date);
        return date1.getTime();
    }

    public static String getBirthDate(User user){
        return new SimpleDateFormat("MM/dd/yyyy").format(user.getBirthday());
    }
}
