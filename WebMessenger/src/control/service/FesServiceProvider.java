package control.service;

import model.structural.Contact;

import control.chat.ChatHandler;
import control.chat.ChatServiceListener;
import control.presence.PresenceManager;
import control.service.PresenceServiceListener;
import control.service.ConnectionServiceListener;

public class FesServiceProvider implements ServiceProvider {
    private ConnectionConfiguration configuration;
    private XMPPConnection connection;
    
    public void init(String server, int port) throws Exception {
        configuration = new ConnectionConfiguration(server, port);
		configuration.setSASLAuthenticationEnabled(true);
		configuration.setCompressionEnabled(true);
        
        connection = new XMPPConnection(configuration);
    }

    public PresenceManager login(String username, String password) throws Exception {
        return null;
    }

    public ChatHandler startChat(Contact contact) throws Exception {
        return null;
    }

    public void logout() {
    }
    
    private class RoosterListenerImpl
        implements RoosterListener {
        private PresenceServiceListener listener;

        RoosterListenerImpl(PresenceServiceListener listener) {
            this.listener = listener;
        }

        public void presenceChanged(Presence presence) {
        }

        public void entriesUpdated(Collection<String> arg0) {
        }

        public void entriesDeleted(Collection<String> arg0) {
        }

        public void entriesAdded(Collection<String> arg0) {
        }
    }

    private class ConnectionListenerImpl
        implements ConnectionListener {
        private ConnectionServiceListener listener;

        public ConnectionListenerImpl(ConnectionServiceListener listener) {
            this.listener = listener;
        }

        public void reconnectionSuccessful() {
            
        }

        public void reconnectionFailed(Exception e) {
        }

        public void reconnectingIn(int period) {
        }

        public void connectionClosedOnError(Exception arg0) {
        }

        public void connectionClosed() {
        }
    }
}
