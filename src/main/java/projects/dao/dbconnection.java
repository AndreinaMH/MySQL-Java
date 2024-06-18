package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import projects.exception.dbexception;

public class dbconnection { 

	public static String HOST = "localhost";
	public static String PASSWORD = "projects";
	public static int PORT = 3306;
	public static String SCHEMA = "projects";
	public static String USER = "projects";
	
	public static Connection getconnection () {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER,
				PASSWORD);
		
		try { 
			Connection conn = DriverManager.getConnection(url);
			//we changed the print line for week 10. it used to only say conn successful. 
			System.out.print("conecction successful" + SCHEMA + "is successful. ");
			return conn;
			
		} catch (SQLException e) { 
			System.out.print("Unable to get connection at" + url);
			throw new dbexception ("Unable to get connection at" + url);
		}
	}
}
