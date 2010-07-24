package test;

import java.util.Collection;

import junit.framework.Assert;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.muc.Affiliate;
import org.jivesoftware.smackx.muc.InvitationListener;
import org.jmock.Expectations;
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
	static XMPPConnectionService connectionService;
	static Mockery context;
	
	@BeforeClass static public void
	messageServiceInitiation() throws Exception{
		contact = "leopoldolusquino@gmail.com";
		context = new JUnit4Mockery();
		connectionService = new XMPPConnectionService();
		service = connectionService.chat(contact);
	}
	
	@Test public void
	testInvitation(){
    	final InvitationListener listener = context.mock(InvitationListener.class);
    	final XMPPConnection connection = null;
    	
    	try {
    		service.invite(contact, "");
			connectionService.getMultiChat().addInvitationListener(connection, listener);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		context.checking(new Expectations() {{
			allowing (listener).invitationReceived(
					connection, 
					with(any(String.class)),
					with(any(String.class)),
					with(any(String.class)),
					with(any(String.class)),
					with(any(Message.class)));
		}});
    }
		
	@Test public void
	testKick() throws XMPPException{
		service.kick(contact, "");
		Collection<Affiliate> contacts = connectionService.getMultiChat().getMembers();
		Assert.assertFalse(contacts.contains(contact));
	}
}