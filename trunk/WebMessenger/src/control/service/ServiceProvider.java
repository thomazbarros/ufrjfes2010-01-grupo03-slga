package control.service;

public interface ServiceProvider {
	public void setConnectionListener(ConnectionListener listener);
	
	public PresenceManager login(String username, String password) throws Exception;
	
	public ChatManager chat(String contact) throws Exception;
	
}
