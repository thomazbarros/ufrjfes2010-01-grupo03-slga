package test;

import java.util.Collection;

import org.jivesoftware.smackx.muc.Affiliate;
import org.jivesoftware.smackx.muc.DefaultParticipantStatusListener;
import org.jivesoftware.smackx.muc.MultiUserChat;

@RunWith(Mock.class)
public class MessageServiceTest{
	static MessageService service;
	
	@BeforeClass static public void
	messageInitiation(){
		service = new XMPPMessageService();
	}
	
	@Test public void
	kick(){
		MultiUserChat multiuserchat = new MultiUserChat(null, message);
		Collection<Affiliate> contacts = multiuserchat.getMembers();
		DefaultParticipantStatusListener participants;
		String contact;
		Assert.assertTrue(participants.kicked(contact));
	}
}