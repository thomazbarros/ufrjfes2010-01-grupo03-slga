package control.base;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.MessageListener;

import control.top.MessageReceiver;
import control.top.MessageService;
import control.wrap.XMPPMessageListener;

public class XMPPMessageService implements
	XMPPMessageListener,
	MessageService {
	
	private Chat chat;
	private ChatManager chatManager;
	private String contact;
	
	public XMPPMessageService(ChatManager manager, String contact) {
		// TODO Auto-generated method stub
		this.chatManager = manager;
		this.contact = contact;
	}
	
	@Override
	public void addMessageReceiver(MessageReceiver receiver) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void createChat(MessageListener listener){
		chat = chatManager.createChat(contact, listener);
	}
	
	@Override
	public void send(String message) throws Exception {
		chat.sendMessage(message);
	}
}
