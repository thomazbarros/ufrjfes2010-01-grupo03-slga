package control.top;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;

import view.MainWindow;
import view.MessageWindow;

import com.vaadin.Application;

import control.base.xmpp.XMPPConnectionService;

@SuppressWarnings("serial")
public class Messenger extends Application {
	private XMPPConnectionService connectionService;
	private MessageService service;
	private MessageWindow messageWindow = new MessageWindow();
	
	@Override
	public void init() {
		connectionService = new XMPPConnectionService();
		
		//connectionService.setConnectionListener(this);
		try{
			connectionService.connect("talk.google.com",5222);
			connectionService.login("falsoparafes@gmail.com","euaindasouumcorreiodeteste");
			service = connectionService.chat("gust.has@gmail.com");
			service.createChat(new MessageListener() {
				@Override
				public void processMessage(Chat chat, Message message) {
					System.out.println("Received message: " + message);
					messageWindow.setOutputText(message.toString());
				}
			});
		}catch(Exception e){
			
		}
		
		setMainWindow(new MainWindow("Luiz"));
	}
	
	public void connectionEvent(String value){
		
	}
	

}
