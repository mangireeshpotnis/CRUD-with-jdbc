package pk_1;
//importing 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner; 

public class Main {	
	
	public static void main(String[] args) {
		
		
		int choice=0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("enter 1 to display employee");
			System.out.println("enter 2 to add employee");
			System.out.println("enter 3 to update employee");
			System.out.println("enter 4 to delete employee");
			System.out.println("enter 5 to exit");
			System.out.println("--->");
			try{choice = sc.nextInt();}
			catch(Exception e) {System.out.println("incorrect type of entry");}
			

			if(choice ==1) {
				DatabaseOperations dbo = new DatabaseOperations();
				dbo.getAllEmployee();
			}
			else if(choice==2) {
				System.out.print("Enter Employee Name -->");
				String name=sc.next();
				System.out.print("\nEnter Employee City -->");
				String city=sc.next();
				System.out.print("\nEnter Employee Phone -->");
				String phone=sc.next();
				System.out.print("\nEnter Employee Salary -->");
				int salary=sc.nextInt();
				
				// we're adding employee so we'll need a new object
				Employee emp = new Employee(name,city,phone,salary);
				//and now database operation for that employee emp
				DatabaseOperations dbo = new DatabaseOperations(emp);
				boolean is_inserted= false;
				is_inserted = dbo.insertEmployee();
				
				if(is_inserted != false) {
					System.out.println("record inserted successfull! ");
				}
				else {
					System.out.println("could not insert the record! ");
				}				

			}
			else if(choice==3) {
				System.out.println("For which id do you wanna update details");
				int id = sc.nextInt();
				System.out.println("what do you wanna change? ");
				System.out.println("Option 1: name");
				System.out.println("Option 2: city");
				System.out.println("Option 3: phone");
				System.out.println("Option 4: salary");
				int option = sc.nextInt();
				if(option == 4) {
					System.out.println("what will be the new value?");
					int newValue = sc.nextInt();
					DatabaseOperations dbo = new DatabaseOperations();
					boolean is_updated = false;
					is_updated = dbo.updateSalary( id, newValue); 
					if(is_updated == false) {
						System.out.println("could not update the record");
					}
					else {
						System.out.println("Salary updated successfully!");
					}
					
				}
				else if(option == 1) {
					System.out.println("what will be the new value?");
					String newValue = sc.next();
					DatabaseOperations dbo = new DatabaseOperations();
					boolean is_updated = false;
					is_updated = dbo.updateName( id, newValue); 
					if(is_updated == false) {
						System.out.println("could not update the record");
					}
					else {
						System.out.println("name updated successfully!");
					}
					
						
				}
				else if(option == 2) {
					System.out.println("what will be the new value?");
					String newValue = sc.next();
					DatabaseOperations dbo = new DatabaseOperations();
					boolean is_updated = false;
					is_updated = dbo.updateCity( id, newValue); 
					if(is_updated == false) {
						System.out.println("could not update the record");
					}
					else {
						System.out.println("name updated successfully!");
					}
					
				}
				else if(option == 3) {
					System.out.println("what will be the new value?");
					String newValue = sc.next();
					DatabaseOperations dbo = new DatabaseOperations();
					boolean is_updated = false;
					is_updated = dbo.updatePhone( id, newValue); 
					if(is_updated == false) {
						System.out.println("could not update the record");
					}
					else {
						System.out.println("name updated successfully!");
					}
					
				}
					
				
				
				
			}
			else if(choice==4) {
				
				System.out.println("Enter id for which u wanna delete record");
				int id = sc.nextInt();
				DatabaseOperations dbo = new DatabaseOperations();			
				dbo.deleteEmployeeIf(id);
				System.out.println("record deleted successfully");
				
				
								
			}

			else if(choice==5) {
				System.out.println("ok bye");
				break;

			}
			else {
				System.out.println("Invalid choice! ");

			}


		}




	}

}


