package by.belstu.it.EmployeeFactory;

import by.belstu.it.Company.Employee;

public interface EmployeeFactory
{
	Employee getEmployee();
	Employee getEmployee(String name, Employee.Qualification qualification, boolean gender, int age);
}
