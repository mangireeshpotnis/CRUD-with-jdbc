package pk_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner; 

public class DatabaseConnection {
	
	public static Connection getConnection() {
		Connection is_connected = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// loading driver is automated since jdk 6
			String username = "root";
			String password="root";
			String url="jdbc:mysql://localhost/emp_db"; //3306 is default port
						
			// establish connection
			is_connected = DriverManager.getConnection(url,username,password); //getConnection is of type Connnection.. hence we created variable of class Connection
			
			
		} catch (ClassNotFoundException| SQLException e1) {
			
			e1.printStackTrace();
		}	
		/*
		if(is_connected == null) {
			System.out.println("not connected");
		}
		else {
			System.out.println("connected");
		}
		*/
		return is_connected;
	}
	



}
