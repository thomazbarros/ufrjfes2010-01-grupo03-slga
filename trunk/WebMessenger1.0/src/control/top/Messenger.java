package control.top;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;

import view.MainWindow;
import view.MessageWindow;

import com.vaadin.Application;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import control.base.xmpp.XMPPConnectionService;

@SuppressWarnings("serial")
public class Messenger extends Application implements
	ConnectionListener,ClickListener {
	private XMPPConnectionService connectionService;
	private MessageService service;
	//private MessageWindow messageWindow = new MessageWindow();
	private MessageWindow message;
	
	//public MessageWindow getMessage() {
	//	return message;
	//}

	@Override
	public void init() {
		final MainWindow window = new MainWindow("Luiz");
		message = window.getMessageWindow();
		message.startChat("flavio.franca.ufrj@gmail.com");
		
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
		ClickListener c = new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				System.out.println("Botao :D");
				try{
					service.send(message.getInputText());
				}catch(Exception e){
					
				}
				
				message.esvaziaInputText();
			
			}
		};
		
		message.setListenerButton(c);
		
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
	
	/*public void buttonClick(){
		try{
			service.send(message.getInputText());
		}catch(Exception e){
			
		}
		
		message.esvaziaInputText();
	}*/

	@Override
	public void buttonClick(ClickEvent event) {
		System.out.println("Botao :D");
		try{
			service.send(message.getInputText());
		}catch(Exception e){
			
		}
		
		message.esvaziaInputText();
	
	}

}
