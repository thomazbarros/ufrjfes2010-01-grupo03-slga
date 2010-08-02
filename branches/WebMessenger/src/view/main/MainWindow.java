package view.main;

import com.vaadin.ui.Window;

public class MainWindow extends Window {
	
	private MessageWindow messageWindow = new MessageWindow();
	
	public MainWindow(String username) {
		super("WebMessenger");
		
		
		
		messageWindow.center();
		addWindow(messageWindow);
		
		messageWindow.startChat("Leopoldo");
		messageWindow.startChat("Gustavo");
	}
	
}
