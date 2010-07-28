package control.base;

import org.jivesoftware.smack.ReconnectionManager;

import control.top.ReconnectionManagerService;

public class XMPPReconnectionManagerService implements
		ReconnectionManagerService {
	
	private ReconnectionManager reconnect;
	
	@Override
	public void connectionClosed() {
		reconnect.connectionClosed();
	}

	@Override
	public void reconnectingIn(int seconds) {
		reconnect.reconnectingIn(seconds);
	}
}
