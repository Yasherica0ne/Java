package by.belstu.it.EmployeeFactory;

import by.belstu.it.Company.Employee;
import by.belstu.it.Company.SysAdmin;

public class SysAdminFactory implements EmployeeFactory
{
	@Override
	public Employee getEmployee()
	{
		Employee.getLOG().info("get SysAdmin");
		return new SysAdmin();
	}

	@Override
	public Employee getEmployee(String name, Employee.Qualification qualification, boolean gender, int age)
	{
		Employee.getLOG().info("get SysAdmin with params");
		return new SysAdmin(name, qualification, gender, age);
	}
}
