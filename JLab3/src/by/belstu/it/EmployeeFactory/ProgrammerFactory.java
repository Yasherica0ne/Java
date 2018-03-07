package by.belstu.it.EmployeeFactory;

import by.belstu.it.Company.Employee;
import by.belstu.it.Company.Programmer;

public class ProgrammerFactory implements EmployeeFactory
{
	@Override
	public Employee getEmployee()
	{
		Employee.getLOG().info("get Programmer");
		return new Programmer();
	}

	@Override
	public Employee getEmployee(String name, Employee.Qualification qualification, boolean gender, int age)
	{
		Employee.getLOG().info("get Programmer with params");
		return new Programmer(name, qualification, gender, age);
	}
}
