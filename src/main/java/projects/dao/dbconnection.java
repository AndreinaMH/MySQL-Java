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
			Connection conexion = DriverManager.getConnection(url);
			System.out.print("conecction successful");
			return conexion;
			
		}catch (SQLException E) { 
			System.out.print("connection failed " + E);
			throw new dbexception ("connection failed at", E);
		}
	}
}
