package control.top;

public interface ConnectionListener {
	public void connectionEvent(String message);
	public void reconnectionEvent(String message);
	public void disconnectionEvent(String message);
}
