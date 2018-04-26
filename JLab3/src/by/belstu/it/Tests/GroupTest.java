package by.belstu.it.Tests;

public class GroupTest
{
	@org.testng.annotations.Test(groups={"unit1","integration"})
	public void testingMethod1() {
		System.out.println("testingMethod1");
	}

	@org.testng.annotations.Test(groups={"unit2","integration"})
	public void testingMethod2() {
		System.out.println("testingMethod2");
	}

	@org.testng.annotations.Test(groups={"unit1"})
	public void testingMethod3() {
		System.out.println("testingMethod3");
	}

	@org.testng.annotations.Test(groups={"unit1", "unit2"})
	public void testingMethod4() {
		System.out.println("testingMethod4");
	}
}
