package control.base;

public interface PresenceListener {
	public void entered(String contact);
	public void quited(String contact);
	public void update(String contact, String status);
}
