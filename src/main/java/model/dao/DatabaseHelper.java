package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseHelper {
	public static Connection openConnection() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/btl_ltm","root","");
		return connection;
	}
}
