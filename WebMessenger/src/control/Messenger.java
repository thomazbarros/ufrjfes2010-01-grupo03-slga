package control.top;

import java.util.Map;

import view.TextInterface;
import control.base.ChatListener;
import control.base.ChatManager;
import control.base.ConnectionListener;
import control.base.PresenceListener;
import control.base.PresenceManager;
import control.base.ServiceProvider;

public class Messenger {
	private static String server;
	private static int port;
	
	private ServiceProvider provider;
	private PresenceManager presence;
	private Map<String, ChatManager> chats;
	
	private ConnectionListener connectionListener;
	private PresenceListener presenceListener;
	private ChatListener chatListener;
	
	public Messenger(String username, String password) throws Exception {
		TextInterface text = new TextInterface();
		connectionListener = text;
		presenceListener = text;
		chatListener = text;
		
		provider = new FesServiceProvider(server, port);
		provider.setConnectionListener(connectionListener);
		presence = provider.login(username, password);
		presence.setPresenceListener(presenceListener);
	}
	
	private ChatManager getChat(String contact) throws Exception {
		if(chats.containsKey(contact))
			return chats.get(contact);
		ChatManager manager = provider.chat(contact);
		manager.setChatListener(chatListener);
		return manager;
	}
	
	public void chat(String contact) throws Exception {
		getChat(contact);
	}
	
	public void sendMessage(String contact, String message) throws Exception {
		getChat(contact).send(message);
	}
}
