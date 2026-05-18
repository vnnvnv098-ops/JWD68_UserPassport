package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static Connection con=null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jwd68","root","zizawar");
					System.out.println("con"+con);
					
		} catch (ClassNotFoundException e) {
			
			
			System.out.println("Driver"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("connection error"+e.getMessage());
		}
		return con;
	}
	
	}


