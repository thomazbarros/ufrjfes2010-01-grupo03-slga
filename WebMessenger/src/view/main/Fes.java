package view.main;

import com.vaadin.Application;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.ui.*;

public class WebMessenger extends Application {
	@Override
	public void init() {
		setMainWindow(new MainWindow("Luiz"));
	}

}
