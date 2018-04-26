package by.belstu.it.Company;

import by.belstu.it.EmployeeFactory.EmployeeFactory;
import org.testng.annotations.Test;

public class Ingeneer extends Employee
{
	public static int getSalary(Qualification qualifi)
	{
		Employee.getLOG().info("get Salary for Ingeneer");
		switch(qualifi)
		{
			case junior: return 300;
			case middle: return 900;
			case senior: return  2000;
			default: return -1;
		}
	}

	public static String IngeneerWork = "Ingeneers work";

	@Override
	public String DoingWork()
	{
		return "Ingeneers work";
	}

	public Ingeneer(String name, Qualification qualification, boolean male, int age)
	{
		super(name, qualification, male, age, getSalary(qualification));
	}

	public Ingeneer()
	{
		super("IvanIngeneer", Qualification.junior, true, 23, getSalary(Qualification.junior));
	}

	@Test
	public void initEnvironmentTest() {
		System.out.println("This is initEnvironmentTest");
	}
}
