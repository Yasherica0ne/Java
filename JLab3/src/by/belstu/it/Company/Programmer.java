package by.belstu.it.Company;

import org.testng.annotations.Test;

public class Programmer extends Employee
{
	public static int getSalary(Qualification qualifi)
	{
		Employee.getLOG().info("get Salary for Programmer");
		switch(qualifi)
		{
			case junior: return 350;
			case middle: return 1000;
			case senior: return  2500;
			default: return -1;
		}
	}

	public static String ProgrammerWork = "Programmers work";

	@Override
	public String DoingWork()
	{
		return "Programmers work";
	}

	public Programmer()
	{
		super("IvanProga", Qualification.junior, true, 24, getSalary(Qualification.junior));
	}
	public Programmer(String name, Qualification qualification, boolean gender, int age)
	{
		super(name, qualification, gender, age, getSalary(qualification));
	}

	@Test(dependsOnMethods={"initEnvironmentTest"})
	public void testmethod() {
		System.out.println("This is testmethod");
	}
}
