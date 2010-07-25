package control.base;

import model.percistence.AbstractXML;

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
	private AbstractXML abstractXML;
	private String id;
	
	public XMPPMessageService(ChatManager manager, String contact, AbstractXML abstractXML) {
		// TODO Auto-generated method stub
		this.chatManager = manager;
		this.contact = contact;
		this.abstractXML = abstractXML;
	}
	
	@Override
	public void addMessageReceiver(MessageReceiver receiver) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void createChat(MessageListener listener){
		chat = chatManager.createChat(contact, listener);
		id = abstractXML.iniciaChat();
	}
	
	@Override
	public void send(String message) throws Exception {
		chat.sendMessage(message);
		chat.getParticipant();
		abstractXML.gravaMensagemEnviada(message, id);
	}
}
