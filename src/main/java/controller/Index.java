package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/", "/index" })
public class Index extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) 
    		throws ServletException, IOException
    {
        try {
            Object user = request.getSession().getAttribute("user");
            if (user == null)
                throw new Exception("User is invalid!");

            if (user.toString() != null && !user.toString().isEmpty()) {
                response.sendRedirect("Home");   
            }
            else throw new Exception("User is not exist!");
        }
        catch (Exception ex) {
            response.sendRedirect("login");
        }
    }
}