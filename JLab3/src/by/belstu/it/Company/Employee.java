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
	private boolean gender;
	private int age;
	private int salary;

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
				", isMale=" + gender +
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

	public Employee(String name, Qualification qualification, boolean gender, int age, int salary)
	{
		this.qualification = qualification;
		this.gender = gender;
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

	public boolean isGender()
	{
		return gender;
	}

	public void setGender(boolean gender)
	{
		this.gender = gender;
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
