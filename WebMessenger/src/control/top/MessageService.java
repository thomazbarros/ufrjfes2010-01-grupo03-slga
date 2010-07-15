package control.top;

import org.jivesoftware.smack.XMPPException;

public interface MessageService extends MessageSender {
	public void addMessageReceiver(MessageReceiver receiver);
	
	public void invite(String contact, String inivitationMessage);
	public void kick(String contact, String reason) throws XMPPException;
}
