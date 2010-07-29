package test;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import control.base.xmpp.XMPPConnectionService;
import control.base.xmpp.XMPPContactService;

public class ContactServiceTest {
	
	static XMPPConnectionService connection;
	static XMPPContactService service;
	
	@BeforeClass static public void
	conatactTest(){
		connection = new XMPPConnectionService();
		service = connection.getContactManagerService();
	}
	
	@Test public void
	addContactTest(){
		service.addContact("gustavo.cpii.ufrj@gmail.com", "Gustavo", "Grupo");
		Assert.assertTrue(service.contains("gustavo.cpii.ufrj@gmail.com"));
	}
	
	@Test public void
	removeContactTest(){
		service.removeContact("gustavo.cpii.ufrj@gmail.com");
		Assert.assertFalse(service.contains("gustavo.cpii.ufrj@gmail.com"));
	}
}
