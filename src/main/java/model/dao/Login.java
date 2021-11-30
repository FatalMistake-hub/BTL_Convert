package model.dao;

import java.sql.*;

public class Login {
    public boolean isVaildUser(String username, String password) {
        try {
            if (username == null || password == null)
                return false;

            boolean result = false;

            Connection con = DatabaseHelper.openConnection();  
            Statement stmt = con.createStatement();
            String query = "select * from Account where User = '" +  username + "'";            
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                if (rs.getString("User").equals(username.toLowerCase())) {
                    if (rs.getString("Pass").equals(password.toLowerCase())) {
                        result = true;
                        break;
                    }
                }
            }

            return result;
        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
}
