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
	
	private void initConnection(String server, int port) {
		ConnectionConfiguration configuration = new
		ConnectionConfiguration(server, port, "gmail.com");
		configuration.setSASLAuthenticationEnabled(true);
		configuration.setCompressionEnabled(true);
		this.connection = new XMPPConnection(configuration);
	}
	
	public XMPPConnectionService(String server, int port) {
		initConnection(server, port);
		this.listeners = new TreeSet<ConnectionListener>();
		this.chats = new TreeSet<XMPPMessageService>();
	}
	
	@Override
	public void addConnectionListener(ConnectionListener listener) {
		listeners.add(listener);
	}

	@Override
	public MessageService chat(String contact) throws Exception {
		if(isAuthenticated()) {
			MultiUserChat chat = new MultiUserChat(connection, "asd");
			XMPPMessageService messageService = new XMPPMessageService(chat,contact);
			chats.add(messageService);
		}
		return null;
	}

	@Override
	public void connect(String server, int port) throws Exception {
		connection.connect();
	}

	@Override
	public void disconnect() {
		connection.disconnect();
	}

	@Override
	public boolean isAuthenticated() {
		return connection.isAuthenticated();
	}

	@Override
	public boolean isConnected() {
		return connection.isConnected();
	}

	@Override
	public PresenceService login(String username, String password) throws Exception {
		connection.login(username, password);
		XMPPPresenceService presence = new XMPPPresenceService(connection);
		sendConnectionEvent("Connected...");
		return presence;
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
}
