package control.base.xmpp;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import model.percistence.AbstractXML;

import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;

import control.top.ConnectionListener;
import control.top.ConnectionService;
import control.top.ContactManagerService;
import control.top.MessageService;
import control.top.PresenceService;
import control.wrap.XMPPConnectionListener;

public class XMPPConnectionService implements
	ConnectionService,
	XMPPConnectionListener {
	
	private XMPPConnection connection;
	private Set<ConnectionListener> listeners;
	private Map<String, MessageService> chats;
	private AbstractXML abstractXML;
	private XMPPContactManagerService contactManagerService;
	
	private void initConnection(String server, int port) {
		ConnectionConfiguration configuration = new
		ConnectionConfiguration(server, port, "gmail.com");
		configuration.setSASLAuthenticationEnabled(true);
		configuration.setCompressionEnabled(true);
		this.connection = new XMPPConnection(configuration);
		contactManagerService = new XMPPContactManagerService(connection);
	}
	
	public XMPPConnectionService() {
		this.listeners = new TreeSet<ConnectionListener>();
		this.chats = new TreeMap<String, MessageService>();
		this.abstractXML = new AbstractXML();
	}
	
	@Override
	public void addConnectionListener(ConnectionListener listener) {
		listeners.add(listener);
	}

	@Override
	public void connect(String server, int port) throws Exception {
		initConnection(server, port);
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
		sendConnectionEvent("Connected...");
		abstractXML.setUser(username);
		return new XMPPPresenceService(connection);
	}
	
	@Override
	public MessageService chat(String contact) throws Exception {
		ChatManager manager = connection.getChatManager();
		if(!isAuthenticated()) return null;
	
		MessageService service = new XMPPMessageService(manager, contact, abstractXML);
		chats.put(contact, service);
		return service;
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
	
	public XMPPConnection getConexao(){
		return connection;
	}

	public XMPPContactManagerService getContactManagerService() {
		return contactManagerService;
	}

}
