package control.top;

public interface PresenceService {
	public void addPresenceListener(PresenceListener listener);
	
	public String getStatus();
	public void setStatus(String status);
}
