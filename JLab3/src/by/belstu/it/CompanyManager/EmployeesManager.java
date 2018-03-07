package by.belstu.it.CompanyManager;

import by.belstu.it.Company.Employee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesManager implements Comparator<Employee>
{
	@XmlElement(name = "employee")
	List<Employee> employeeList;

	public EmployeesManager()
	{
		employeeList = new ArrayList<Employee>();
	}

	private EmployeesManager(List<Employee> employeeList)
	{
		this.employeeList = employeeList;
	}

	public List<Employee> getEmployeeList()
	{
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList)
	{
		this.employeeList = employeeList;
	}

	public boolean add(Employee employee)
	{
		this.employeeList.add(employee);
		return true;
	}

	public boolean remove(Employee employee)
	{
		this.employeeList.remove(employee);
		return true;
	}

	public void printEmployees()
	{
		for (Employee employee : employeeList)
		{
			Employee.getLOG().info(employee.toString());
		}
	}

	public static void printList(List<Employee> list)
	{
		for(Employee impl : list)
		{
			Employee.getLOG().info(impl.toString());
		}
	}

	@Override
	public int compare(Employee o1, Employee o2)
	{
		if(o1.getSalary() == o2.getSalary()) return 0;
		else if(o1.getSalary() > o2.getSalary()) return 1;
		else return -1;
	}
}
