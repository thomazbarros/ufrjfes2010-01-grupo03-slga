package control.top;

import test.TestAccount;
import view.MainWindow;

import com.vaadin.Application;

import control.base.xmpp.XMPPConnectionService;

@SuppressWarnings("serial")
public class Messenger extends Application {
	private ConnectionService connectionService;
	
	
	@Override
	public void init() {
		connectionService = new XMPPConnectionService();
				
		
		setMainWindow(new MainWindow("Luiz"));
	}

}
