package control.base.xmpp;

import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;

import control.top.ContactService;

public class XMPPContactService implements ContactService{
	XMPPConnection connection;
	
	public XMPPContactService(XMPPConnection connection){
		this.connection = connection;
	}
	
	public void addContact(String contact,String name, String[] group ){
		try{
		 connection.getRoster().createEntry(contact, name , group);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void removeContact(String contact){
		RosterEntry contactEntry = connection.getRoster().getEntry(contact);
		try{
			connection.getRoster().removeEntry(contactEntry);		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
