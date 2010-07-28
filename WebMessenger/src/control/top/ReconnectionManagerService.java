package control.top;

public interface ReconnectionManagerService {
	public void connectionClosed();
	public void reconnectingIn(int seconds);
}
