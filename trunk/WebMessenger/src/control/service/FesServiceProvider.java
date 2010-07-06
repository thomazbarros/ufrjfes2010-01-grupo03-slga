package control.service;

import control.base.ChatManager;
import control.base.ConnectionListener;
import control.base.PresenceManager;
import control.base.ServiceProvider;

public class FesServiceProvider implements ServiceProvider {
	
	public FesServiceProvider(String server, int port) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ChatManager chat(String contact) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PresenceManager login(String username, String password)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnectionListener(ConnectionListener listener) {
		// TODO Auto-generated method stub

	}

}
