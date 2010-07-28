package test;

import junit.framework.Assert;

import org.jivesoftware.smack.XMPPException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import control.base.XMPPConnectionService;
import control.top.AccountManagerService;
import control.top.PresenceListener;
import control.top.PresenceService;

@RunWith(JMock.class)
public class AccountManagerServiceTest {
	static Mockery context;
	static AccountManagerService service;
	
	@BeforeClass static public void
	accountInitiation(){
		context = new JUnit4Mockery();
	}
	
	@Test public void
	createAccountTest() throws XMPPException{
		XMPPConnectionService connection = new XMPPConnectionService();
		service.createAccount("accountManager", "password");
		
		final PresenceListener listener = context.mock(PresenceListener.class);
    	
    	try {
			PresenceService presence = connection.login("accountManager", "password");
			presence.addPresenceListener(listener);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		context.checking(new Expectations() {{
			allowing (listener).updateEvent(
					with(any(String.class)),
					with(any(String.class)));
		}});
		
		Assert.assertTrue(connection.isAuthenticated());
	}
}
