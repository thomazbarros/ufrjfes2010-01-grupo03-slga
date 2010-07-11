package control.base;

import java.util.Set;
import java.util.TreeSet;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.muc.MultiUserChat;

import control.top.ConnectionListener;
import control.top.ConnectionService;
import control.top.MessageService;
import control.top.PresenceService;
import control.wrap.XMPPConnectionListener;

public class XMPPConnectionService implements
	ConnectionService,
	XMPPConnectionListener {
	
	private XMPPConnection connection;
	private Set<ConnectionListener> listeners;
	private Set<XMPPMessageService> chats;
	
	public XMPPConnectionService() {
		this.connection = null;
		this.listeners = new TreeSet<ConnectionListener>();
		this.chats = new TreeSet<XMPPMessageService>();
	}
	
	private void sendConnectionEvent(String message) {
		for (ConnectionListener listener : listeners) {
			listener.connectionEvent(message);
		}
	}
	
	private void sendReconnectionEvent(String message) {
		for (ConnectionListener listener : listeners) {
			listener.reconnectionEvent(message);
		}
	}
	
	private void sendDisconnectionEvent(String message) {
		for (ConnectionListener listener : listeners) {
			listener.disconnectionEvent(message);
		}
	}
	
	@Override
	public void addConnectionListener(ConnectionListener listener) {
		listeners.add(listener);
	}

	@Override
	public MessageService chat(String contact) throws Exception {
		if(connection != null) {
			MultiUserChat multiChat = new MultiUserChat(connection,"myroom1@gmail.com");
			XMPPMessageService messageService = new XMPPMessageService(multiChat,contact);
			chats.add(messageService);
		}
		return null;
	}

	@Override
	public void connect(String server, int port) throws Exception {
		if(connection != null)
			disconnect();
		
		ConnectionConfiguration configuration = new
		ConnectionConfiguration(server, port, "gmail.com");
		configuration.setSASLAuthenticationEnabled(true);
		configuration.setCompressionEnabled(true);
		connection = new XMPPConnection(configuration);
		connection.connect();
	}

	@Override
	public void disconnect() {
		if(connection != null)
			connection.disconnect();
		connection = null;
	}

	@Override
	public boolean isAuthenticated() {
		if(connection != null)
			return connection.isAuthenticated();
		return false;
	}

	@Override
	public boolean isConnected() {
		if(connection != null)
			return connection.isConnected();
		return false;
	}

	@Override
	public PresenceService login(String username, String password) throws Exception {
		if(connection != null) {
			connection.login(username, password);
			XMPPPresenceService presence = new XMPPPresenceService(connection);
			sendConnectionEvent("Connected...");
			return presence;
		}
		return null;
	}

	@Override
	public void connectionClosed() {
		sendDisconnectionEvent("Connection Closed...");
	}

	@Override
	public void connectionClosedOnError(Exception e) {
		sendDisconnectionEvent("Connection closed on error(" + e + ")...");
	}

	@Override
	public void reconnectingIn(int t) {
		sendReconnectionEvent("Reconnecting in " + t + "...");
	}

	@Override
	public void reconnectionFailed(Exception e) {
		sendReconnectionEvent("Reconnection failed on error(" + e + ")");
	}

	@Override
	public void reconnectionSuccessful() {
		sendConnectionEvent("Connected...");
	}

}
