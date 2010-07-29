package control.top;

import view.MainWindow;

import com.vaadin.Application;

@SuppressWarnings("serial")
public class Messenger extends Application {
	@Override
	public void init() {
		setMainWindow(new MainWindow("Luiz"));
	}

}
