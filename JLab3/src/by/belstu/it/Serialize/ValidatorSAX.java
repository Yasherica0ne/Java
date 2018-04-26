package by.belstu.it.Serialize;

import by.belstu.it.CompanyManager.EmployeesManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSAX
{
	//private static final Logger LOG = Logger.getLogger(ValidatorSAX.class);

	public void valid()
	{
//		String filename = "files/airlist.xml";
//		String schemaname = "files/air.xsd";
//		String logname = "log/log.xml";
//		Schema schems = null;
//		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
//		SchemaFactory factory = SchemaFactory.newInstance(language);
//		try
//		{
//			schems = factory.newSchema(new File(schemaname));
//			Validator validator = schems.newValidator();
//			Source source;
//			source = new StreamSource(filename);
//			EmployeesManager sh = new EmployeesManager();
//			validator.setErrorHandler();
//			validator.validate(source);
//			LOG.info(filename + "is valid");
//		} catch (SAXException e)
//		{
//			LOG.error(filename + " SAX error " + e.getMessage());
//		} catch (IOException e)
//		{
//			LOG.error(" io error " + e.getMessage());
//		} catch (SAXException e)
//		{
//			e.printStackTrace();
//		}
	}
}
