package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.PDF;

public class PDF_DAO {
	public PDF getURLByID(Integer ID) {
        try {
        	Connection con = DatabaseHelper.openConnection(); 
            String query = "select * from pdfconvert where ID = " + ID.toString();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            PDF pdf = new PDF();
            while (rs.next()) {
                pdf.setID(rs.getInt("ID"));
                pdf.setUser(rs.getString("User"));
                pdf.setFileName(rs.getString("FileName"));
                pdf.setFilePath(rs.getString("FilePath"));
                pdf.setTargetPath(rs.getString("TargetPath"));
                pdf.setResult(rs.getInt("Result"));
                
                break;
            }
            rs.close();

            return pdf;
        }
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    public List<PDF> getURLbyUser(String user) {
        try {
            List<PDF> list = new ArrayList<PDF>();
            
            Connection con = DatabaseHelper.openConnection();   
            Statement stmt = con.createStatement();
            String query = "select * from pdfconvert where User = '" + user + "'";
            ResultSet rs = stmt.executeQuery(query);         

            while (rs.next()) {
            	PDF item = new PDF();
                item.setID(rs.getInt("ID"));
                item.setUser(rs.getString("User"));
                item.setFileName(rs.getString("FileName"));
                item.setFilePath(rs.getString("FilePath"));
                item.setTargetPath(rs.getString("TargetPath"));
                item.setResult(rs.getInt("Result"));

                list.add(item);
            }

            return list;
        }
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    

    

    public void setURLResult(String sourcePath, Integer result) {
        try {
            // If result code is not from below code, return
            List<Integer> acceptable = new ArrayList<Integer>();
            acceptable.add(-1); // Error
            acceptable.add(0); // Pending
            acceptable.add(1); // Converting
            acceptable.add(2); // Successful
            if (!acceptable.contains(result))
                return;

            Connection con = DatabaseHelper.openConnection(); 
            String query = "update pdfconvert set Result = ? where FilePath = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, result);
            ps.setString(2, sourcePath);
            ps.execute();
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
    public void addDOC(PDF pdf) {
        try {
        	Connection con = DatabaseHelper.openConnection(); 
            // https://stackoverflow.com/a/10167435    
            String query = "insert into pdfconvert (User, FileName, FilePath, TargetPath, Result) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pdf.getUser());
            ps.setString(2, pdf.getFileName());
            ps.setString(3, pdf.getFilePath());
            ps.setString(4, pdf.getTargetPath());
            ps.setInt(5, pdf.getResult());

            ps.execute();
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
