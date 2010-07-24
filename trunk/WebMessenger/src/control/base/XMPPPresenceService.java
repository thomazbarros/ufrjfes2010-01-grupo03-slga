package control.base;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Presence;

import control.top.PresenceListener;
import control.top.PresenceService;
import control.wrap.XMPPPreseneListener;

public class XMPPPresenceService implements
	PresenceService,
	XMPPPreseneListener {
	
	private XMPPConnection connection;
	private Set<PresenceListener> listeners;
	
	public XMPPPresenceService(XMPPConnection connection) {
		this.connection = connection;
		this.listeners = new TreeSet<PresenceListener>();
	}
	
	@Override
	public void addPresenceListener(PresenceListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void setStatus(String status) {
		Presence presence = new Presence(Presence.Type.available);
	    presence.setStatus(status);
	    presence.setPriority(24);
	    presence.setMode(Presence.Mode.available);
	    connection.sendPacket(presence);
	}

	@Override
	public void entriesAdded(Collection<String> entries) {
		
	}

	@Override
	public void entriesDeleted(Collection<String> entries) {
		
	}

	@Override
	public void entriesUpdated(Collection<String> entries) {
		
	}

	@Override
	public void presenceChanged(Presence presence) {
		for (PresenceListener listener : listeners) {
			listener.updateEvent(presence.getFrom(), presence.getMode().name());
		}
	}
}
