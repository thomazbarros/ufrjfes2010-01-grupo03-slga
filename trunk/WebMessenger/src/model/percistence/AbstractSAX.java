package model.percistence;

import java.io.FileReader;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class AbstractSAX extends DefaultHandler
{
	public AbstractSAX()
	{
		super();
	}
	
	public static void parsing (String args[]) throws Exception
    {
		XMLReader xr = XMLReaderFactory.createXMLReader();
		AbstractSAX handler = new AbstractSAX();
		xr.setContentHandler(handler);
		xr.setErrorHandler(handler);
		for (int i = 0; i < args.length; i++) {
		    FileReader r = new FileReader(args[i]);
		    xr.parse(new InputSource(r));
		}
    }
	
	public String startElement (String uri, String name, String qName, Attributes atts)
	{
		if ("".equals (uri))
			return new String("Start element: " + qName);
		return new String("Start element: {" + uri + "}" + name);
	}

	
	public String endElement (String uri, String name, String qName)
	{
		if ("".equals (uri))
			return new String("End element: " + qName);
		else
			return new String("End element: {" + uri + "}" + name);
	}
	
	
	public void characters (char ch[], int start, int length)
	{
		System.out.print("Characters:    \"");
		for (int i = start; i < start + length; i++) {
			switch (ch[i]) {
		   	  case '\\':
				System.out.print("\\\\");
				break;
			  case '"':
				System.out.print("\\\"");
				break;
			  case '\n':
				System.out.print("\\n");
				break;
			  case '\r':
				System.out.print("\\r");
				break;
			  case '\t':
				System.out.print("\\t");
				break;
			  default:
				System.out.print(ch[i]);
				break;
			}
		}
		System.out.print("\"\n");
	}
}