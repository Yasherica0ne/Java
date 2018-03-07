package by.belstu.it.Main;

import by.belstu.it.Company.Director;
import by.belstu.it.Company.Employee;
import by.belstu.it.CompanyManager.EmployeesManager;
import by.belstu.it.EmployeeFactory.Factories;
import by.belstu.it.EmployeeFactory.IngeneerFactory;
import by.belstu.it.EmployeeFactory.ProgrammerFactory;
import by.belstu.it.EmployeeFactory.SysAdminFactory;
import by.belstu.it.Serialize.Serializer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.Serializable;

public class Main
{
	static{     new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository()); }

	private static final Logger LOG = Logger.getLogger(Main.class);

	public static void main(String[] args)
	{
		try
		{
			String filePath = "inits.xml";
			LOG.info("Starting program_____________________________");
			//logger.debug("Hello world.");
			Director director = Director.getDirector();
			EmployeesManager manager1 = new EmployeesManager();
			Factories.employeeConsumer(manager1, new IngeneerFactory());
			Factories.employeeConsumer(manager1, new SysAdminFactory());
			Factories.employeeConsumer(manager1, new SysAdminFactory(), "Vitaliy", Employee.Qualification.senior, true, 20);
			Factories.employeeConsumer(manager1, new ProgrammerFactory(), "Victor", Employee.Qualification.senior, true, 19);
			Factories.employeeConsumer(manager1, new ProgrammerFactory());
			Factories.employeeConsumer(manager1, new ProgrammerFactory(), "Andrej", Employee.Qualification.middle, true, 18);
			LOG.info("Manager1");
			manager1.printEmployees();
			LOG.info("Manager2");
//			Serializer.Serialize(manager1, filePath);
			EmployeesManager manager2 = new EmployeesManager();
			manager2.setEmployeeList(Serializer.Deserialize(filePath));
			manager2.printEmployees();
			LOG.info("Количество сотрудников в manager1: " + director.getEmployeesCount(manager1));
			director.sortEmployeers(manager1); // По зарплате
			LOG.info("Сортировка по зарпалате");
			manager1.printEmployees();
			LOG.info("Поиск сотрудников с квалификацией senior");
			EmployeesManager.printList(director.findEmployee(manager1, Employee.Qualification.senior));
			LOG.info("End program_____________________________");
		}
		catch (Exception ex)
		{
			LOG.error(ex.getMessage());
		}
	}
}
