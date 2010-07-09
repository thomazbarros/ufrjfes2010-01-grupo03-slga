package test;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import control.base.XMPPConnectionService;
import control.top.ConnectionService;
import control.top.PresenceListener;
import control.top.PresenceService;

@RunWith(JMock.class)
public class ConnectionServiceTest {
    static Mockery context;
    static ConnectionService service;
    
    @BeforeClass static public void
    connectionInitiation() {
    	context = new JUnit4Mockery();
    	service = new XMPPConnectionService();
    }
    
    @Test public void
    testConnect() {
    	try {
    		service.connect(TestAccount.server, TestAccount.port);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	Assert.assertTrue(service.isConnected());
    }
    
    @Test public void
    testLogin()  {
    	final PresenceListener listener = context.mock(PresenceListener.class);
    	
    	try {
			PresenceService presence = service.login(TestAccount.username, TestAccount.password);
			presence.addPresenceListener(listener);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		context.checking(new Expectations() {{
			allowing (listener).updateEvent(
					with(any(String.class)),
					with(any(String.class)));
		}});
		
		Assert.assertTrue(service.isAuthenticated());
    }
    
    @Test public void
    testLogout() {
    	service.disconnect();
		
		Assert.assertFalse(service.isConnected());
		Assert.assertFalse(service.isAuthenticated());
    }
}