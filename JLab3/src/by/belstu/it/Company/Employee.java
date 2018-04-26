package by.belstu.it.Company;
import org.apache.log4j.Logger;

public class Employee
{
	protected static final Logger LOG = Logger.getLogger(Employee.class);

	public static Logger getLOG()
	{
		return LOG;
	}

	public enum Qualification
	{
		junior, middle, senior
	}
	private String name;
	private Qualification qualification;
	private boolean isMale;
	private int age;
	private int salary;

	public static String EmployeeWork = "Employees work";

	public String DoingWork()
	{
		return "Employees work";
	}

	@Override
	public String toString()
	{
		String emplr = null;
		if(this instanceof Ingeneer) emplr = "Ingeneer";
		else if (this instanceof SysAdmin) emplr = "SysAdmin";
		else if(this instanceof Programmer) emplr = "Programmer";
		else emplr = "Employee";
		return emplr + "{" +
				"name='" + name + '\'' +
				", qualification=" + qualification +
				", isMale=" + isMale +
				", age=" + age +
				", salary=" + salary +
				'}';
	}

	//public abstract int getSalary(Qualification qualifi);

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Employee(String name, Qualification qualification, boolean isMale, int age, int salary)
	{
		this.qualification = qualification;
		this.isMale = isMale;
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

	public Employee() {}

	public Qualification getQualification()
	{
		return qualification;
	}

	public void setQualification(Qualification qualification)
	{
		this.qualification = qualification;
	}

	public boolean isMale()
	{
		return isMale;
	}

	public void setMale(boolean male)
	{
		this.isMale = male;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}
}
