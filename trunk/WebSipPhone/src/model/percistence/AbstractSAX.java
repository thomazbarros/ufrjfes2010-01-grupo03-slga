import org.xml.sax.helpers.DefaultHandler;

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
}