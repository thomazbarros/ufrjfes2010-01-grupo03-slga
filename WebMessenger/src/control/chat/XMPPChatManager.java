package control.top;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

import control.base.ChatListener;
import control.base.ChatManager;

public class XMPPChatManager implements ChatManager {
	
	private org.jivesoftware.smack.ChatManager chatManager;
	private XMPPServiceProvider serviceProvider;
	private Chat newChat;
	
	public XMPPChatManager(){
		chatManager = serviceProvider.getConnection().getChatManager();
	}
	
	@Override
	public void send(String message) throws XMPPException {
		// TODO Auto-generated method stub
		Message newMessage = new Message();
		newMessage.setBody(message);
		newChat.sendMessage(newMessage);
	}

	@Override
	public void setChatListener(ChatListener listener) {
		// TODO Auto-generated method stub

	}

}
