package by.belstu.it.EmployeeFactory;

import by.belstu.it.Company.Employee;
import by.belstu.it.Company.Ingeneer;

public class IngeneerFactory implements EmployeeFactory
{
	@Override
	public Employee getEmployee()
	{
		Employee.getLOG().info("Get Ingeneer");
		return new Ingeneer();
	}

	@Override
	public Employee getEmployee(String name, Employee.Qualification qualification, boolean gender, int age)
	{
		Employee.getLOG().info("Get Ingeneer with params");
		return new Ingeneer(name, qualification, gender, age);
	}
}
