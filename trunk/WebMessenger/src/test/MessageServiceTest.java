package test;

import java.util.Collection;

import junit.framework.Assert;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.muc.Affiliate;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import control.base.XMPPConnectionService;
import control.top.MessageService;

@RunWith(JMock.class)
public class MessageServiceTest{
	static MessageService service;
	static String contact;
	static XMPPConnectionService connection;
	static Mockery context;
	
	@BeforeClass static public void
	messageInitiation() throws Exception{
		contact = "leopoldolusquino@gmail.com";
		context = new JUnit4Mockery();
		connection = new XMPPConnectionService();
		service = connection.chat(contact);
	}
	
	@Test public void
	kick() throws XMPPException{
		service.kick(contact, "");
		Collection<Affiliate> contacts = connection.getMultiChat().getMembers();
		Assert.assertNull(contacts);
	}
	
	@Test public void
	send() throws XMPPException{
		service.send("Cante e seja feliz!");
		Assert.assertEquals("Cante e seja feliz!", connection.getMultiChat().nextMessage().toString());
	}
}