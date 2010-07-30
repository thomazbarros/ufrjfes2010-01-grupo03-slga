package control.top;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;
import org.vaadin.artur.icepush.ICEPush;

import view.MainWindow;
import view.MessageWindow;

import com.vaadin.Application;

import control.base.xmpp.XMPPConnectionService;

@SuppressWarnings("serial")
public class Messenger extends Application implements
	ConnectionListener {
	private XMPPConnectionService connectionService;
	private MessageService service;
	private MessageWindow messageWindow = new MessageWindow();
	
	@Override
	public void init() {
		final MainWindow window = new MainWindow("Luiz");
		MessageWindow message = window.getMessageWindow();
		message.startChat("gust.has@gmail.com");
		
		connectionService = new XMPPConnectionService();
		//connectionService.addConnectionListener(this);
		try{
			connectionService.connect("talk.google.com",5222);
			connectionService.login("falsoparafes@gmail.com","euaindasouumcorreiodeteste");
			//connectionService.getContactManagerService().addContact("flavio.franca.ufrj@gmail.com", "FLAVIO", null);
			service = connectionService.chat("gust.has@gmail.com");
			
			service.createChat(new MessageListener(){
				@Override
				public void processMessage(Chat chat, Message message){
					System.out.println(message.getBody());
					window.getMessageWindow().setOutputText(message.getBody());
					//window.requestRepaintAll();
				}
			});
					//message);
			//service.addMessageReceiver(message);
			
			
		}catch(Exception e){
			
		}
		
		setMainWindow(window);
	}

	@Override
	public void connectionEvent(String message) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void reconnectionEvent(String message) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void disconnectionEvent(String message) {
		// TODO Auto-generated method stub
		
	}

}
