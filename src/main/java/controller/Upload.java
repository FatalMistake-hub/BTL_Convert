package controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import model.bean.PDF;


@WebServlet(urlPatterns = { "/upload" })
@MultipartConfig(
       maxFileSize = 31457280,
       maxRequestSize = 52428800) 
public class Upload extends HttpServlet {

	
    private static final long serialVersionUID = 1L;
    public static String FilePath = "C:\\Users\\rumra\\OneDrive\\Tài liệu\\ltmck";
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) 
    		throws ServletException, IOException
    {
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/upload.jsp");
		rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) 
    		throws ServletException, IOException
    {
        try {
            request.setCharacterEncoding("UTF-8");
            Part filePart = request.getPart("file");

            if(filePart!=null) {

            PDF pdf = new PDF();
            // Convert File
            
            pdf.setUser(request.getSession().getAttribute("user").toString());
            pdf.setFileName(Paths.get(filePart.getSubmittedFileName()).getFileName().toString());
            pdf.setFilePath(FilePath + "\\" + filePart.getSubmittedFileName() + ".docx");
            pdf.setTargetPath(FilePath + "\\" + filePart.getSubmittedFileName() + ".pdf");
            pdf.setResult(0);

            filePart.write(pdf.getFilePath());
            model.bo.PDF_BO data = new model.bo.PDF_BO();
            data.addDOC(pdf);
            model.bo.Handle_Thread.AddtoThread(pdf);
            }

            response.sendRedirect("Home");
        }
        catch (Exception ex) {
            System.out.println(ex);
            response.sendRedirect("upload");
        }
    }
}
