package by.belstu.it.Tests;

import by.belstu.it.Company.*;
import by.belstu.it.CompanyManager.EmployeesManager;
import by.belstu.it.EmployeeFactory.Factories;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Tests
{
	SysAdmin SysAsminVitaliy = new SysAdmin("Vitaliy", Employee.Qualification.senior, true, 20);
	Programmer ProgrammerVictor = new Programmer("Victor", Employee.Qualification.senior, true, 19);
	Ingeneer IngeneerAndrej = new Ingeneer("Andrej", Employee.Qualification.middle, true, 18);


	@AfterSuite
	public void testIngeneer() throws Exception
	{
		Assert.assertEquals(Ingeneer.IngeneerWork, IngeneerAndrej.DoingWork());
	}

	@BeforeTest
	public void testProgrammer() throws Exception
	{
		Assert.assertEquals(Programmer.ProgrammerWork, ProgrammerVictor.DoingWork());
	}

	@BeforeSuite
	public void testSysAdmin() throws Exception
	{
		Assert.assertEquals(SysAdmin.IngeneerWork, SysAsminVitaliy.DoingWork());
	}

	EmployeesManager manager = new EmployeesManager();

	@org.testng.annotations.Test
	public void testEmployeeManager() throws Exception
	{
		Assert.assertEquals(1, manager.compare(SysAsminVitaliy, IngeneerAndrej));
	}

	@org.testng.annotations.Test(enabled = false)
	public void testDisabled() throws Exception
	{
		Assert.assertEquals(Programmer.ProgrammerWork, ProgrammerVictor.DoingWork());
		System.out.println("Methods is ignore!");
	}

	@org.testng.annotations.Test(timeOut = 1000)
	public void waitLongTime() throws Exception
	{
		Thread.sleep(950);
	}
}
