package control.base;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.muc.MultiUserChat;

import control.top.MessageReceiver;
import control.top.MessageService;
import control.wrap.XMPPMessageListener;

public class XMPPMessageService implements
	XMPPMessageListener,
	MessageService {
	
	private MultiUserChat multiUserChat;
	private String contact;
	
	public XMPPMessageService(MultiUserChat multiUserChat, String contact){
		multiUserChat = this.multiUserChat;
		contact = this.contact;
	}

	@Override
	public void addMessageReceiver(MessageReceiver receiver) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void invite(String contact, String invitationMessage) {
		multiUserChat.invite(contact, invitationMessage);
	}

	@Override
	public void kick(String contact, String reason) throws XMPPException{
		multiUserChat.kickParticipant(contact, reason);
	}

	@Override
	public void send(String message) throws XMPPException {
		multiUserChat.sendMessage(message);
	}
}