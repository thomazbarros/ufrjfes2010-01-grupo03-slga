package control.top;

public interface PresenceListener {
	public void enterEvent(String contact);
	public void leaveEvent(String contact);
	public void updateEvent(String contact, String status);
}
