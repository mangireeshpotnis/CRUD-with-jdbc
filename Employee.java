package pk_1;
// model class that acts like database
public class Employee {
	String name;
	String city;
	String phone;
	int salary;
	
	public Employee() {
		
	}
	
	public Employee(String name, String city, String phone, int salary) {
		this.name = name;
		this.city = city;
		this.phone = phone;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	

	public String getCity() {
		return city;
	}

	

	public String getPhone() {
		return phone;
	}

	

	public int getSalary() {
		return salary;
	}

	

}
