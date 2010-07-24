package control.top;

public interface MessageService extends MessageSender {
	public void addMessageReceiver(MessageReceiver receiver);
	
	public void invite(String contact);
	public void kick(String contact) throws Exception;
}
