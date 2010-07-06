package control.service;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

import control.base.ChatManager;
import control.base.ConnectionListener;
import control.base.PresenceManager;
import control.base.ServiceProvider;

public class XMPPServiceProvider implements ServiceProvider {
	
	private ConnectionConfiguration configuration;
	private XMPPConnection connection;
	private XMPPChatHandler chatHandler;
	private ConnectionListener connectionListener;
	
	public XMPPServiceProvider(String server, int port) throws XMPPException {
		// TODO Auto-generated constructor stub
		
		configuration = new ConnectionConfiguration(server, port);
		configuration.setCompressionEnabled(true);
		configuration.setSASLAuthenticationEnabled(true);
		
		connection = new XMPPConnection(configuration);
		chatHandler = new XMPPChatHandler();
		connectionListener = new ConectionListener();
	}

	@Override
	public ChatManager chat(String contact) throws Exception {
		ChatManager chatmanager = connection.getChatManager();
		// TODO Auto-generated method stub
		
		Chat newChat = chatmanager.createChat(contact,chatHandler);

		return chatmanager;
	}

	@Override
	public PresenceManager login(String username, String password)
			throws Exception {
		// TODO Auto-generated method stub
		connection.connect();
		connection.login(username, password);
		return null;
	}

	@Override
	public void setConnectionListener(ConnectionListener listener) {
		// TODO Auto-generated method stub
		this.conectionListener = listener;

	}

	public ConnectionConfiguration getConfiguration() {
		return configuration;
	}

	public XMPPConnection getConnection() {
		return connection;
	}

}
