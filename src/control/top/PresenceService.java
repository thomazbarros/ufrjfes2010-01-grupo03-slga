package control.top;

public interface PresenceService {
	public void addPresenceListener(PresenceListener listener);
	
	public void setStatus(String status);
}
