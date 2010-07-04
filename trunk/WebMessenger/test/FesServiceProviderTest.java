import control.service.FesServiceProvider;
import org.junit.Test;

public class FesServiceProviderTest{
	
	FesServiceProvider fes;
	
	@Test public void initTest(){
		String server = "talk.google.com";
		int port = 2555;
		fes.init(server, port);
		assertNull(fes.getConnection());
	}
}