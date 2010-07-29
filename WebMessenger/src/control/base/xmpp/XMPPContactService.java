package control.base.xmpp;

import java.util.ArrayList;

import org.jivesoftware.smack.PrivacyListManager;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.PrivacyItem;
import org.jivesoftware.smack.packet.PrivacyItem.PrivacyRule;

import control.top.ContactService;

public class XMPPContactService implements ContactService{
	XMPPConnection connection;
	
	public XMPPContactService(XMPPConnection connection){
		this.connection = connection;
	}
	
	public void addContact(String contact,String name, String group ){
		String []groups = new String[1];
		groups[0] = group;
		try{
		 connection.getRoster().createEntry(contact, name , groups);
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
