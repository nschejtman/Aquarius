package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Helloworld", urlPatterns = "/hello_world")
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {


        res.setContentType("text/html");
        PrintWriter out = res.getWriter();


        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H1>Hello World</H1>");
        out.println("Today is: " + (new java.util.Date().toString()));
        out.println("</BODY></HTML>");
    } // doGet

} // HelloWorldServlet
