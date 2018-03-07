package by.belstu.it.Company;

public class SysAdmin extends Employee
{
	public static int getSalary(Qualification qualifi)
	{
		Employee.getLOG().info("get Salary for SysAdmin");
		switch(qualifi)
		{
			case junior: return 250;
			case middle: return 700;
			case senior: return  1500;
			default: return -1;
		}
	}

	public SysAdmin()
	{
		super("IvanSysAdmon", Qualification.senior, true, 24, getSalary(Qualification.junior));
	}
	public SysAdmin(String name, Qualification qualification, boolean gender, int age)
	{
		super(name, qualification, gender, age, getSalary(qualification));
	}
}
