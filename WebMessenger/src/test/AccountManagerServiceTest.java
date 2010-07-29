package test;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import control.base.xmpp.XMPPConnectionService;
import control.top.AccountService;
import control.top.PresenceListener;
import control.top.PresenceService;

@RunWith(JMock.class)
public class AccountManagerServiceTest {
	static Mockery context;
	static AccountService service;
	static XMPPConnectionService connection;
	
	@BeforeClass static public void
	accountInitiation() throws Exception{
		context = new JUnit4Mockery();
		
		connection = new XMPPConnectionService();
		connection.connect("jabber.org",TestAccount.port);
		service = connection.getAccountManagerService();
	}
	
	@Test public void
	createAccountTest() throws Throwable{
		try{
			service.createAccount("accountManager", "password");
		} catch (Exception e){
			e.printStackTrace();
		}
		
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
	
	@Test public void
	changePasswordTest() throws Exception{
		service.changePassword("test");
		
		connection.disconnect();
		connection.connect(TestAccount.server, TestAccount.port);
		service = connection.getAccountManagerService();
		
		final PresenceListener listener = context.mock(PresenceListener.class);
    	
    	try {
			PresenceService presence = connection.login("accountManager", "test");
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
	
	@Test public void
	deleteAccountTest() throws Throwable{
		try{
			service.deleteAccount();
		} catch (Exception e){
			e.printStackTrace();
		}
		
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
		
		Assert.assertFalse(connection.isAuthenticated());
	}
}