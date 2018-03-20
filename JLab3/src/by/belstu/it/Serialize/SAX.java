package by.belstu.it.Serialize;

import by.belstu.it.Company.Employee;
import by.belstu.it.CompanyManager.EmployeesManager;
import com.sun.javafx.scene.layout.region.Margins;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import javax.management.MalformedObjectNameException;
import java.util.ArrayList;
import java.util.List;

public class SAX extends DefaultHandler
{
	List<Employee> list;
	Employee empl;
	String thisElement = "";

	public List<Employee> getResult()
	{
		return list;
	}

	@Override
	public void startDocument() throws SAXException
	{
		Employee.getLOG().info("Start parse XML...");
	}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException
	{
		thisElement = qName;
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException
	{
		thisElement = "";
	}

	@Override
	public void characters(char[] ch, int start, int length)
	{
		if(thisElement.equals("")) return;
		else if (thisElement.equals("employee"))
		{
			empl = new Employee();
		}
		else if (thisElement.equals("age"))
		{
			empl.setAge(Integer.parseInt(new String(ch, start, length)));
		}
		else if (thisElement.equals("male"))
		{
			empl.setMale(Boolean.parseBoolean(new String(ch, start, length)));
		}
		else if (thisElement.equals("name"))
		{
			empl.setName(new String(ch, start, length));
		}
		else if (thisElement.equals("qualification"))
		{
			Employee.Qualification qualification = null;
			switch (new String(ch, start, length))
			{
				case "junior":
					qualification = Employee.Qualification.junior;
				case "middle":
					qualification = Employee.Qualification.middle;
				case "senior":
					qualification = Employee.Qualification.senior;
			}
			if (empl != null) empl.setQualification(qualification);
			else try
			{
				throw new Exception("Параметр qualification не распознан");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else if (thisElement.equals("salary"))
		{
			empl.setSalary(Integer.parseInt(new String(ch, start, length)));
			list.add(empl);
		}
		else if(thisElement.equals("employees")) list = new ArrayList<Employee>();
	}

	@Override
	public void endDocument()
	{
		Employee.getLOG().info("Stop parse XML...");
	}
}

