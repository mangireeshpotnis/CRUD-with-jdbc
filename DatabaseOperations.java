package pk_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner; 

public class DatabaseOperations {
	Employee employee;
//	
	public DatabaseOperations(Employee emp) {
		this.employee = emp;
	}
	public DatabaseOperations() {
		
	}
	// 
	public  void getAllEmployee() {
		ResultSet result = null;
		//establish connection
		Connection is_connected = DatabaseConnection.getConnection();
		//make statement: select * so statement
		String select_query = "select * from emp";
		try{
			Statement s=is_connected.createStatement();
			result = s.executeQuery(select_query);
			if(result != null) {
				while(result.next()) {
					
					System.out.println("ID    :"+ result.getInt(1));
					System.out.println("NAME  :"+ result.getString(2));
					System.out.println("City  :"+ result.getString(3));
					System.out.println("PHONE :"+ result.getString(4));
					System.out.println("SALARY:"+ result.getInt(5));
					System.out.println("-----------------------------------------------------------------------------------------------");
					
				}
			}
			else {
				System.out.println("record not found! ");
			}
		}
		catch(SQLException e) {
			
		}		
		
	}
	
	
	public boolean insertEmployee() {
		boolean is_inserted = false;
		// establish connection
		Connection is_connected = DatabaseConnection.getConnection();
		//make statement
		String insert_query = "insert into emp(name,city,phone,salary) values(?,?,?,?)";
		// dynamic query so prepareStatement
		
		try {
			PreparedStatement ps = is_connected.prepareStatement(insert_query);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getCity());
			ps.setString(3, employee.getPhone());
			ps.setInt(4, employee.getSalary());
			ps.executeUpdate();
			is_inserted = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is_inserted;
		
		
	}
	
	public boolean updateName(int id,String newValue) {
		ResultSet result = null;
		boolean is_updated = false;
		//establish connection
		Connection is_connected = DatabaseConnection.getConnection();
		//make statement
		String select_Query = "select * from emp where id=?";
		try {
			PreparedStatement ps1=is_connected.prepareStatement(select_Query);
			ps1.setInt(1, id);
			result = ps1.executeQuery();
			if(result.next()) {
				String update_name_Query = "update emp set name = ? where id =?";
				PreparedStatement ps2 = is_connected.prepareStatement(update_name_Query);
				ps2.setString(1, newValue);
				ps2.setInt(2, id);
				ps2.executeUpdate();
				is_updated = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is_updated;
		
	}
	public boolean updateCity(int id,String newValue) {
		ResultSet result = null;
		boolean is_updated = false;
		//establish connection
		Connection is_connected = DatabaseConnection.getConnection();
		//make statement
		String select_Query = "select * from emp where id=?";
		try {
			PreparedStatement ps1=is_connected.prepareStatement(select_Query);
			ps1.setInt(1, id);
			result = ps1.executeQuery();
			if(result.next()) {
				String update_name_Query = "update emp set city = ? where id =?";
				PreparedStatement ps2 = is_connected.prepareStatement(update_name_Query);
				ps2.setString(1, newValue);
				ps2.setInt(2, id);
				ps2.executeUpdate();
				is_updated = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is_updated;
		
		
	}
	public boolean updatePhone(int id,String newValue) {
		ResultSet result = null;
		boolean is_updated = false;
		//establish connection
		Connection is_connected = DatabaseConnection.getConnection();
		//make statement
		String select_Query = "select * from emp where id=?";
		try {
			PreparedStatement ps1=is_connected.prepareStatement(select_Query);
			ps1.setInt(1, id);
			result = ps1.executeQuery();
			if(result.next()) {
				String update_name_Query = "update emp set phone = ? where id =?";
				PreparedStatement ps2 = is_connected.prepareStatement(update_name_Query);
				ps2.setString(1, newValue);
				ps2.setInt(2, id);
				ps2.executeUpdate();
				is_updated = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is_updated;
		
	}
	public boolean updateSalary(int id,int newValue) {
		boolean is_updated = false;
		ResultSet result = null;
		//establish Connection
		Connection is_connected = DatabaseConnection.getConnection();
		//make statement if id exists...
		String select_query = "select * from emp where id=?";
		try {
			PreparedStatement ps1 = is_connected.prepareStatement(select_query);
			ps1.setInt(1,id);
			result = ps1.executeQuery();
			if(result.next()) {
				String update_sal_query = "update emp set salary = ? where id=?";
				
				PreparedStatement ps2 = is_connected.prepareStatement(update_sal_query);
				ps2.setInt(1, newValue);
				ps2.setInt(2, id);
				ps2.executeUpdate();
				is_updated=true;					
			}
			else {
				System.out.println("No such id exists!");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return is_updated;	
		
		
		
		
		
	}
	
	
	
	
	
	public void deleteEmployeeIf(int id) {
		ResultSet result = null;
		// if result exists... then only u can delete
		Connection is_connected = DatabaseConnection.getConnection();
		//select and see if id exists. Dynamic so we use PreparedStatement
		String select_query = "select * from emp where id = ?";
		try {
			PreparedStatement ps = is_connected.prepareStatement(select_query);
			ps.setInt(1, id);
			result = ps.executeQuery();
			if(result.next()) {
				delete(id);
			}
			else {
				System.out.println("no such id exists! ");
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
	
	public boolean delete(int id) {
		boolean is_deleted = false;
		//establish connection
		Connection is_connected = DatabaseConnection.getConnection();
		//make statement: dynamic so PreparedStatement
		String delete_query = "delete from emp where id=?";
		try {
			PreparedStatement ps = is_connected.prepareStatement(delete_query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return is_deleted;
	}
	
	

}
