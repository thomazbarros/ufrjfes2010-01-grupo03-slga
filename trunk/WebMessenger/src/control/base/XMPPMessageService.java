package control.base;

import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.muc.MultiUserChat;

import control.top.MessageReceiver;
import control.top.MessageService;
import control.wrap.XMPPMessageListener;

public class XMPPMessageService implements
	XMPPMessageListener,
	MessageService {
	
	public XMPPMessageService(ChatManager manager, String contact) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void addMessageReceiver(MessageReceiver receiver) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void invite(String contact) {
		// TODO Auto-generated method stub
	}

	@Override
	public void kick(String contact) throws Exception{
		// TODO Auto-generated method stub
	}

	@Override
	public void send(String message) throws Exception {
		// TODO Auto-generated method stub
	}
}
