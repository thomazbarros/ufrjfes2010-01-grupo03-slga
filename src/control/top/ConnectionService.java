package control.top;

public interface ConnectionService {
	public void addConnectionListener(ConnectionListener listener);
	
	public void connect(String server, int port) throws Exception;
	public void disconnect();
	
	public PresenceService login(String username, String password) throws Exception;
	public MessageService chat(String contact) throws Exception;
	
	public boolean isConnected();
	public boolean isAuthenticated();
}
