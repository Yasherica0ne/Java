package by.belstu.it.Serialize;

import by.belstu.it.Company.Employee;
import by.belstu.it.CompanyManager.EmployeesManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

public class Serializer
{
	public static void Serialize(EmployeesManager manager, String fileName) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeesManager.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//Marshal the employees list in console
		jaxbMarshaller.marshal(manager, new File(fileName));
//		try (OutputStreamWriter oos = new OutputStreamWriter(new FileOutputStream(fileName)))
//		{
//			Marshaller jaxbMarshaller = JAXBContext.newInstance(EmployeesManager.class).createMarshaller();
//			OutputStream out = new ByteArrayOutputStream(256);
//			jaxbMarshaller.marshal(manager, out);
//			oos.write(out.toString());
//			System.out.println("Запись произведена");
//		} catch (Exception ex)
//		{
//			Employee.getLOG().error(ex.getMessage());
//		}
	}

	// десериализация в новый список
	public static List<Employee> Deserialize(String fileName) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeesManager.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		//We had written this file in marshalling example
		EmployeesManager manager = (EmployeesManager) jaxbUnmarshaller.unmarshal( new File(fileName) );
		return manager.getEmployeeList();
	}
}
