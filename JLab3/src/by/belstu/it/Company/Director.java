package by.belstu.it.Company;

import by.belstu.it.CompanyManager.EmployeesManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Director
{
	private static Director director;

	public static Director getDirector()
	{
		if(director == null) director = new Director();
		return director;
	}


	protected Director() { }

	public int getEmployeesCount(EmployeesManager manager)
	{
		return manager.getEmployeeList().size();
	}

	public void sortEmployeers(EmployeesManager manager)
	{
		Collections.sort(manager.getEmployeeList(), manager);
	}

	public List<Employee> findEmployee(EmployeesManager manager, Employee.Qualification qualify)
	{
		List<Employee> list = new ArrayList<Employee>();
		for (Employee employee : manager.getEmployeeList())
		{
			if (employee.getQualification().equals(qualify)) list.add(employee);
		}
		return list;
	}
}
