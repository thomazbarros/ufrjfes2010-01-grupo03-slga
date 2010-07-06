package control.presence;

public interface PresenceManager {
	public void logout();
	
	public void setStatus(String status);
	
	public void setPresenceListener(PresenceListener listener);
}
