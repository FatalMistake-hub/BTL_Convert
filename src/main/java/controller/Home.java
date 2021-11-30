package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Home" })
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request,HttpServletResponse response) 
    		throws ServletException, IOException
    {
        model.bo.PDF_BO data = new model.bo.PDF_BO();
        
        Object user = request.getSession().getAttribute("user");
//        if (user == null) {
//            response.sendRedirect("index");
//            return;
//        }

        request.setAttribute("data", data.getURLbyUser(user.toString()));
        String destination = "/Home.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
    }
}

