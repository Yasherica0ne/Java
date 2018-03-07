package by.belstu.it.EmployeeFactory;

import by.belstu.it.Company.Employee;
import by.belstu.it.CompanyManager.EmployeesManager;

import java.util.List;

public class Factories
{
	public static void employeeConsumer(EmployeesManager manager, EmployeeFactory fact)
	{
		Employee s = fact.getEmployee();
		manager.getEmployeeList().add(s);
	}

	public static void employeeConsumer(EmployeesManager manager, EmployeeFactory fact, String name, Employee.Qualification qualification, boolean gender, int age)
	{
		Employee s = fact.getEmployee(name, qualification, gender, age);
		manager.getEmployeeList().add(s);
	}
}
