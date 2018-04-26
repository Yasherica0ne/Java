package by.belstu.it.Serialize;

import by.belstu.it.Company.Employee;
import by.belstu.it.CompanyManager.EmployeesManager;
import com.google.gson.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

import static sun.java2d.loops.SurfaceType.Custom;

public class Serializer // implements JsonSerializer<Employee>, JsonDeserializer<Employee>
{
	public static void Serialize(EmployeesManager manager, String fileName) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeesManager.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(manager, new File(fileName));
	}

	// десериализация в новый список
	public static List<Employee> Deserialize(String fileName) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeesManager.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		//We had written this file in marshalling example
		EmployeesManager manager = (EmployeesManager) jaxbUnmarshaller.unmarshal(new File(fileName));
		return manager.getEmployeeList();
	}

	public static void JInstSerialize(String fileName, Employee manager)
	{
		try (OutputStreamWriter oos = new OutputStreamWriter(new FileOutputStream(fileName)))
		{
			Gson gson = new Gson();
			String s = gson.toJson(manager);
			oos.write(s);
		} catch (Exception ex)
		{
			Employee.getLOG().error(ex.getMessage());
		}
	}

	public static Employee JInstDeserialize(String fileName)
	{
		Employee manager = null;
		try (FileReader isr = new FileReader(fileName))
		{
			Gson gson = new Gson();
			StringBuilder s = new StringBuilder();
			int c;
			while ((c = isr.read()) != -1)
			{
				s.append((char) c);
			}
			manager = gson.fromJson(s.toString(), Employee.class);
		} catch (Exception ex)
		{
			Employee.getLOG().error(ex.getMessage());
		}
		return manager;
	}

	public static void JSerialize(String fileName, EmployeesManager manager)
	{
		try (OutputStreamWriter oos = new OutputStreamWriter(new FileOutputStream(fileName)))
		{
			Gson gson = new Gson();
			String s = gson.toJson(manager);
			oos.write(s);
		} catch (Exception ex)
		{
			Employee.getLOG().error(ex.getMessage());
		}
	}

	public static List<Employee> JDeserialize(String fileName)
	{
		EmployeesManager manager = null;
		try (FileReader isr = new FileReader(fileName))
		{
			Gson gson = new Gson();
			StringBuilder s = new StringBuilder();
			int c;
			while ((c = isr.read()) != -1)
			{
				s.append((char) c);
			}
			manager = gson.fromJson(s.toString(), EmployeesManager.class);
		} catch (Exception ex)
		{
			Employee.getLOG().error(ex.getMessage());
		}
		return manager.getEmployeeList();
	}

	public static List<Employee> SAXDEserialize(String file) throws ParserConfigurationException, SAXException, IOException
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SAX saxp = new SAX();
		parser.parse(new File(file), saxp);
		return saxp.getResult();
	}
}
