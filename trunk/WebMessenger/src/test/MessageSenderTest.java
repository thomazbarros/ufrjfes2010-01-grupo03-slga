package test;

import junit.framework.Assert;

import org.jivesoftware.smack.XMPPException;
import org.junit.BeforeClass;
import org.junit.Test;

import control.base.XMPPConnectionService;
import control.top.MessageService;

public class MessageSenderTest {
	
	static MessageService service;
	static String contact;
	static XMPPConnectionService connectionService;
	
	@BeforeClass static public void
	messageSenderInitiation() throws Exception{
		contact = "leopoldolusquino@gmail.com";
		connectionService = new XMPPConnectionService();
		service = connectionService.chat(contact);
	}
	
	@Test public void
	testSend() throws XMPPException{
		service.send("Cante e seja feliz!");
		Assert.assertEquals("Cante e seja feliz!", connectionService.getMultiChat().nextMessage().toString());
	}
}
