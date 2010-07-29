package control.top;

import org.jivesoftware.smack.MessageListener;

public interface MessageService extends MessageSender {
	public void addMessageReceiver(MessageReceiver receiver);
	
	public void createChat(MessageListener listener);
}
