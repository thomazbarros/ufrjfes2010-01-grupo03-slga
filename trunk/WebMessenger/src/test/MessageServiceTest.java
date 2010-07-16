package test;

import java.util.Collection;

import junit.framework.Assert;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.muc.Affiliate;
import org.jivesoftware.smackx.muc.DefaultParticipantStatusListener;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jmock.integration.junit4.JMock;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import control.base.XMPPConnectionService;
import control.base.XMPPMessageService;
import control.top.ConnectionService;
import control.top.MessageService;

@RunWith(JMock.class)
public class MessageServiceTest{
	static MessageService service;
	static String contact;
	static XMPPConnectionService connection;
	
	@BeforeClass static public void
	messageInitiation() throws Exception{
		contact = "leopoldolusquino@gmail.com";
		connection = new XMPPConnectionService();
		service = connection.chat(contact);
	}
	
	@Test public void
	kick() throws XMPPException{
		service.kick(contact, "");
		Collection<Affiliate> contacts = connection.getMultiChat().getMembers();
		Assert.assertNull(contacts);
	}
}