package control.top;

import org.jivesoftware.smack.XMPPException;

public interface MessageSender {
	public void send(String message) throws XMPPException;
}
