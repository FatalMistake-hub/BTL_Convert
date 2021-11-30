package controller;

import java.io.*;
import java.nio.file.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.bean.PDF;


@WebServlet(urlPatterns = { "/download" })
public class Download extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
    		throws ServletException, IOException
    {
        try {
            Integer fileID = Integer.parseInt(request.getParameter("id"));
            model.bo.PDF_BO Data = new model.bo.PDF_BO();
            PDF pdf = Data.getURLByID(fileID);

            if (pdf.getResult() != 2) {
                response.sendRedirect("Home");
                return;
            }
            Path path = Paths.get(pdf.getTargetPath());
            byte[] data = Files.readAllBytes(path);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename=" + pdf.getFileName() + ".pdf");
            response.setContentLength(data.length);
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            OutputStream outStream = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outStream.close();
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
