package test;

import java.util.Collection;

import junit.framework.Assert;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.muc.Affiliate;
import org.jivesoftware.smackx.muc.DefaultParticipantStatusListener;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jmock.integration.junit4.JMock;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import control.base.XMPPMessageService;
import control.top.MessageService;

@RunWith(JMock.class)
public class MessageServiceTest{
	static MessageService service;
	static MultiUserChat multiUserChat;
	static String contact;
	
	@BeforeClass static public void
	messageInitiation(){
		service = new XMPPMessageService(multiUserChat, contact);
	}
	
	@Test public void
	kick() throws XMPPException{
		service.kick(contact, "");
		Collection<Affiliate> contacts = multiUserChat.getMembers();
		Assert.assertNull(contacts);
	}
}